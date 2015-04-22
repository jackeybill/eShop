package net.shopxx.controller.shop.member;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import net.shopxx.Pageable;
import net.shopxx.controller.shop.BaseController;
import net.shopxx.entity.Member;
import net.shopxx.service.MemberService;
import net.shopxx.service.MessageService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("shopMemberMessageController")
@RequestMapping({"/member/message"})
public class MessageController extends BaseController
{
  private static final int IIIlllll = 10;

  @Resource(name="messageServiceImpl")
  MessageService IIIlllIl;

  @Resource(name="memberServiceImpl")
  MemberService IIIllllI;

  @RequestMapping(value={"/check_username"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public boolean checkUsername(String username)
  {
    return (!StringUtils.equalsIgnoreCase(username, this.IIIllllI.getCurrentUsername())) && (this.IIIllllI.usernameExists(username));
  }

  @RequestMapping(value={"/send"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String send(Long draftMessageId, Model model)
  {
    net.shopxx.entity.Message localMessage = (net.shopxx.entity.Message)this.IIIlllIl.find(draftMessageId);
    if ((localMessage != null) && (localMessage.getIsDraft().booleanValue()) && (localMessage.getSender() == this.IIIllllI.getCurrent()))
      model.addAttribute("draftMessage", localMessage);
    return "/shop/member/message/send";
  }

  @RequestMapping(value={"/send"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String send(Long draftMessageId, String username, String title, String content, @RequestParam(defaultValue="false") Boolean isDraft, HttpServletRequest request, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(net.shopxx.entity.Message.class, "content", content, new Class[0]))
      return "/shop/common/error";
    Member localMember1 = this.IIIllllI.getCurrent();
    net.shopxx.entity.Message localMessage1 = (net.shopxx.entity.Message)this.IIIlllIl.find(draftMessageId);
    if ((localMessage1 != null) && (localMessage1.getIsDraft().booleanValue()) && (localMessage1.getSender() == localMember1))
      this.IIIlllIl.delete(localMessage1);
    Member localMember2 = null;
    if (StringUtils.isNotEmpty(username))
    {
      localMember2 = this.IIIllllI.findByUsername(username);
      if ((localMember2 == null) || (localMember2 == localMember1))
        return "/shop/common/error";
    }
    net.shopxx.entity.Message localMessage2 = new net.shopxx.entity.Message();
    localMessage2.setTitle(title);
    localMessage2.setContent(content);
    localMessage2.setIp(request.getRemoteAddr());
    localMessage2.setIsDraft(isDraft);
    localMessage2.setSenderRead(Boolean.valueOf(true));
    localMessage2.setReceiverRead(Boolean.valueOf(false));
    localMessage2.setSenderDelete(Boolean.valueOf(false));
    localMessage2.setReceiverDelete(Boolean.valueOf(false));
    localMessage2.setSender(localMember1);
    localMessage2.setReceiver(localMember2);
    this.IIIlllIl.save(localMessage2);
    if (isDraft.booleanValue())
    {
      IIIllIlI(redirectAttributes, net.shopxx.Message.success("shop.member.message.saveDraftSuccess", new Object[0]));
      return "redirect:draft.jhtml";
    }
    IIIllIlI(redirectAttributes, net.shopxx.Message.success("shop.member.message.sendSuccess", new Object[0]));
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/view"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String view(Long id, Model model)
  {
    net.shopxx.entity.Message localMessage = (net.shopxx.entity.Message)this.IIIlllIl.find(id);
    if ((localMessage == null) || (localMessage.getIsDraft().booleanValue()) || (localMessage.getForMessage() != null))
      return "/shop/common/error";
    Member localMember = this.IIIllllI.getCurrent();
    if (((localMessage.getSender() != localMember) && (localMessage.getReceiver() != localMember)) || ((localMessage.getReceiver() == localMember) && (localMessage.getReceiverDelete().booleanValue())) || ((localMessage.getSender() == localMember) && (localMessage.getSenderDelete().booleanValue())))
      return "/shop/common/error";
    if (localMember == localMessage.getReceiver())
      localMessage.setReceiverRead(Boolean.valueOf(true));
    else
      localMessage.setSenderRead(Boolean.valueOf(true));
    this.IIIlllIl.update(localMessage);
    model.addAttribute("memberMessage", localMessage);
    return "/shop/member/message/view";
  }

  @RequestMapping(value={"/reply"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String reply(Long id, String content, HttpServletRequest request, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(net.shopxx.entity.Message.class, "content", content, new Class[0]))
      return "/shop/common/error";
    net.shopxx.entity.Message localMessage1 = (net.shopxx.entity.Message)this.IIIlllIl.find(id);
    if ((localMessage1 == null) || (localMessage1.getIsDraft().booleanValue()) || (localMessage1.getForMessage() != null))
      return "/shop/common/error";
    Member localMember = this.IIIllllI.getCurrent();
    if (((localMessage1.getSender() != localMember) && (localMessage1.getReceiver() != localMember)) || ((localMessage1.getReceiver() == localMember) && (localMessage1.getReceiverDelete().booleanValue())) || ((localMessage1.getSender() == localMember) && (localMessage1.getSenderDelete().booleanValue())))
      return "/shop/common/error";
    net.shopxx.entity.Message localMessage2 = new net.shopxx.entity.Message();
    localMessage2.setTitle("reply: " + localMessage1.getTitle());
    localMessage2.setContent(content);
    localMessage2.setIp(request.getRemoteAddr());
    localMessage2.setIsDraft(Boolean.valueOf(false));
    localMessage2.setSenderRead(Boolean.valueOf(true));
    localMessage2.setReceiverRead(Boolean.valueOf(false));
    localMessage2.setSenderDelete(Boolean.valueOf(false));
    localMessage2.setReceiverDelete(Boolean.valueOf(false));
    localMessage2.setSender(localMember);
    localMessage2.setReceiver(localMember == localMessage1.getReceiver() ? localMessage1.getSender() : localMessage1.getReceiver());
    if (((localMember == localMessage1.getReceiver()) && (!localMessage1.getSenderDelete().booleanValue())) || ((localMember == localMessage1.getSender()) && (!localMessage1.getReceiverDelete().booleanValue())))
      localMessage2.setForMessage(localMessage1);
    this.IIIlllIl.save(localMessage2);
    if (localMember.equals(localMessage1.getSender()))
    {
      localMessage1.setSenderRead(Boolean.valueOf(true));
      localMessage1.setReceiverRead(Boolean.valueOf(false));
    }
    else
    {
      localMessage1.setSenderRead(Boolean.valueOf(false));
      localMessage1.setReceiverRead(Boolean.valueOf(true));
    }
    this.IIIlllIl.update(localMessage1);
    if (((localMember == localMessage1.getReceiver()) && (!localMessage1.getSenderDelete().booleanValue())) || ((localMember == localMessage1.getSender()) && (!localMessage1.getReceiverDelete().booleanValue())))
    {
      IIIllIlI(redirectAttributes, IIIlllII);
      return "redirect:view.jhtml?id=" + localMessage1.getId();
    }
    IIIllIlI(redirectAttributes, net.shopxx.Message.success("shop.member.message.replySuccess", new Object[0]));
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Integer pageNumber, Model model)
  {
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    Member localMember = this.IIIllllI.getCurrent();
    model.addAttribute("page", this.IIIlllIl.findPage(localMember, localPageable));
    return "/shop/member/message/list";
  }

  @RequestMapping(value={"/draft"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String draft(Integer pageNumber, Model model)
  {
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    Member localMember = this.IIIllllI.getCurrent();
    model.addAttribute("page", this.IIIlllIl.findDraftPage(localMember, localPageable));
    return "/shop/member/message/draft";
  }

  @RequestMapping(value={"delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public net.shopxx.Message delete(Long id)
  {
    Member localMember = this.IIIllllI.getCurrent();
    this.IIIlllIl.delete(id, localMember);
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.member.MessageController
 * JD-Core Version:    0.6.2
 */