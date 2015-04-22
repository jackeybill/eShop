package net.shopxx.controller.shop.member;

import java.util.Set;
import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.Pageable;
import net.shopxx.controller.shop.BaseController;
import net.shopxx.entity.Area;
import net.shopxx.entity.Member;
import net.shopxx.entity.Receiver;
import net.shopxx.service.AreaService;
import net.shopxx.service.MemberService;
import net.shopxx.service.ReceiverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("shopMemberReceiverController")
@RequestMapping({"/member/receiver"})
public class ReceiverController extends BaseController
{
  private static final int IIIlllIl = 10;

  @Resource(name="memberServiceImpl")
  private MemberService IIIllllI;

  @Resource(name="areaServiceImpl")
  private AreaService IIIlllll;

  @Resource(name="receiverServiceImpl")
  private ReceiverService IIlIIIII;

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Integer pageNumber, ModelMap model)
  {
    Member localMember = this.IIIllllI.getCurrent();
    Pageable localPageable = new Pageable(pageNumber, Integer.valueOf(10));
    model.addAttribute("page", this.IIlIIIII.findPage(localMember, localPageable));
    return "shop/member/receiver/list";
  }

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(RedirectAttributes redirectAttributes)
  {
    Member localMember = this.IIIllllI.getCurrent();
    if ((Receiver.MAX_RECEIVER_COUNT != null) && (localMember.getReceivers().size() >= Receiver.MAX_RECEIVER_COUNT.intValue()))
    {
      IIIllIlI(redirectAttributes, Message.warn("shop.member.receiver.addCountNotAllowed", new Object[] { Receiver.MAX_RECEIVER_COUNT }));
      return "redirect:list.jhtml";
    }
    return "shop/member/receiver/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(Receiver receiver, Long areaId, RedirectAttributes redirectAttributes)
  {
    receiver.setArea((Area)this.IIIlllll.find(areaId));
    if (!IIIllIlI(receiver, new Class[0]))
      return "/shop/common/error";
    Member localMember = this.IIIllllI.getCurrent();
    if ((Receiver.MAX_RECEIVER_COUNT != null) && (localMember.getReceivers().size() >= Receiver.MAX_RECEIVER_COUNT.intValue()))
      return "/shop/common/error";
    receiver.setMember(localMember);
    this.IIlIIIII.save(receiver);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model, RedirectAttributes redirectAttributes)
  {
    Receiver localReceiver = (Receiver)this.IIlIIIII.find(id);
    if (localReceiver == null)
      return "/shop/common/error";
    Member localMember = this.IIIllllI.getCurrent();
    if (localReceiver.getMember() != localMember)
      return "/shop/common/error";
    model.addAttribute("receiver", localReceiver);
    return "shop/member/receiver/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(Receiver receiver, Long id, Long areaId, RedirectAttributes redirectAttributes)
  {
    receiver.setArea((Area)this.IIIlllll.find(areaId));
    if (!IIIllIlI(receiver, new Class[0]))
      return "/shop/common/error";
    Receiver localReceiver = (Receiver)this.IIlIIIII.find(id);
    if (localReceiver == null)
      return "/shop/common/error";
    Member localMember = this.IIIllllI.getCurrent();
    if (localReceiver.getMember() != localMember)
      return "/shop/common/error";
    this.IIlIIIII.update(receiver, new String[] { "member" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long id)
  {
    Receiver localReceiver = (Receiver)this.IIlIIIII.find(id);
    if (localReceiver == null)
      return IIIllIll;
    Member localMember = this.IIIllllI.getCurrent();
    if (localReceiver.getMember() != localMember)
      return IIIllIll;
    this.IIlIIIII.delete(id);
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.shop.member.ReceiverController
 * JD-Core Version:    0.6.2
 */