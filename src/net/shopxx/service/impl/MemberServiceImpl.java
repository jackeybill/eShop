package net.shopxx.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.persistence.LockModeType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import net.shopxx.Page;
import net.shopxx.Pageable;
import net.shopxx.Principal;
import net.shopxx.Setting;
import net.shopxx.dao.DepositDao;
import net.shopxx.dao.MemberDao;
import net.shopxx.entity.Admin;
import net.shopxx.entity.Deposit;
import net.shopxx.entity.Deposit.Type;
import net.shopxx.entity.Member;
import net.shopxx.service.MemberService;
import net.shopxx.util.SettingUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service("memberServiceImpl")
public class MemberServiceImpl extends BaseServiceImpl<Member, Long>
  implements MemberService
{

  @Resource(name="memberDaoImpl")
  private MemberDao IIIllIlI;

  @Resource(name="depositDaoImpl")
  private DepositDao IIIllIll;

  @Resource(name="memberDaoImpl")
  public void setBaseDao(MemberDao memberDao)
  {
    super.setBaseDao(memberDao);
  }

  @Transactional(readOnly=true)
  public boolean usernameExists(String username)
  {
    return this.IIIllIlI.usernameExists(username);
  }

  @Transactional(readOnly=true)
  public boolean usernameDisabled(String username)
  {
    Assert.hasText(username);
    Setting localSetting = SettingUtils.get();
    if (localSetting.getDisabledUsernames() != null)
      for (String str : localSetting.getDisabledUsernames())
        if (StringUtils.containsIgnoreCase(username, str))
          return true;
    return false;
  }

  @Transactional(readOnly=true)
  public boolean emailExists(String email)
  {
    return this.IIIllIlI.emailExists(email);
  }

  @Transactional(readOnly=true)
  public boolean emailUnique(String previousEmail, String currentEmail)
  {
    if (StringUtils.equalsIgnoreCase(previousEmail, currentEmail))
      return true;
    return !this.IIIllIlI.emailExists(currentEmail);
  }

  public void save(Member member, Admin operator)
  {
    Assert.notNull(member);
    this.IIIllIlI.persist(member);
    if (member.getBalance().compareTo(new BigDecimal(0)) > 0)
    {
      Deposit localDeposit = new Deposit();
      localDeposit.setType(operator != null ? Deposit.Type.adminRecharge : Deposit.Type.memberRecharge);
      localDeposit.setCredit(member.getBalance());
      localDeposit.setDebit(new BigDecimal(0));
      localDeposit.setBalance(member.getBalance());
      localDeposit.setOperator(operator != null ? operator.getUsername() : null);
      localDeposit.setMember(member);
      this.IIIllIll.persist(localDeposit);
    }
  }

  public void update(Member member, Integer modifyPoint, BigDecimal modifyBalance, String depositMemo, Admin operator)
  {
    Assert.notNull(member);
    this.IIIllIlI.lock(member, LockModeType.PESSIMISTIC_WRITE);
    if ((modifyPoint != null) && (modifyPoint.intValue() != 0) && (member.getPoint().longValue() + modifyPoint.intValue() >= 0L))
      member.setPoint(Long.valueOf(member.getPoint().longValue() + modifyPoint.intValue()));
    if ((modifyBalance != null) && (modifyBalance.compareTo(new BigDecimal(0)) != 0) && (member.getBalance().add(modifyBalance).compareTo(new BigDecimal(0)) >= 0))
    {
      member.setBalance(member.getBalance().add(modifyBalance));
      Deposit localDeposit = new Deposit();
      if (modifyBalance.compareTo(new BigDecimal(0)) > 0)
      {
        localDeposit.setType(operator != null ? Deposit.Type.adminRecharge : Deposit.Type.memberRecharge);
        localDeposit.setCredit(modifyBalance);
        localDeposit.setDebit(new BigDecimal(0));
      }
      else
      {
        localDeposit.setType(operator != null ? Deposit.Type.adminChargeback : Deposit.Type.memberPayment);
        localDeposit.setCredit(new BigDecimal(0));
        localDeposit.setDebit(modifyBalance);
      }
      localDeposit.setBalance(member.getBalance());
      localDeposit.setOperator(operator != null ? operator.getUsername() : null);
      localDeposit.setMemo(depositMemo);
      localDeposit.setMember(member);
      this.IIIllIll.persist(localDeposit);
    }
    this.IIIllIlI.merge(member);
  }

  @Transactional(readOnly=true)
  public Member findByUsername(String username)
  {
    return this.IIIllIlI.findByUsername(username);
  }

  @Transactional(readOnly=true)
  public List<Member> findListByEmail(String email)
  {
    return this.IIIllIlI.findListByEmail(email);
  }

  @Transactional(readOnly=true)
  public Page<Object> findPurchasePage(Date beginDate, Date endDate, Pageable pageable)
  {
    return this.IIIllIlI.findPurchasePage(beginDate, endDate, pageable);
  }

  @Transactional(readOnly=true)
  public boolean isAuthenticated()
  {
    RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
    if (localRequestAttributes != null)
    {
      HttpServletRequest localHttpServletRequest = ((ServletRequestAttributes)localRequestAttributes).getRequest();
      Principal localPrincipal = (Principal)localHttpServletRequest.getSession().getAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME);
      if (localPrincipal != null)
        return true;
    }
    return false;
  }

  @Transactional(readOnly=true)
  public Member getCurrent()
  {
    RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
    if (localRequestAttributes != null)
    {
      HttpServletRequest localHttpServletRequest = ((ServletRequestAttributes)localRequestAttributes).getRequest();
      Principal localPrincipal = (Principal)localHttpServletRequest.getSession().getAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME);
      if (localPrincipal != null)
        return (Member)this.IIIllIlI.find(localPrincipal.getId());
    }
    return null;
  }

  @Transactional(readOnly=true)
  public String getCurrentUsername()
  {
    RequestAttributes localRequestAttributes = RequestContextHolder.currentRequestAttributes();
    if (localRequestAttributes != null)
    {
      HttpServletRequest localHttpServletRequest = ((ServletRequestAttributes)localRequestAttributes).getRequest();
      Principal localPrincipal = (Principal)localHttpServletRequest.getSession().getAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME);
      if (localPrincipal != null)
        return localPrincipal.getUsername();
    }
    return null;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.service.impl.MemberServiceImpl
 * JD-Core Version:    0.6.2
 */