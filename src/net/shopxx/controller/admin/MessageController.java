package net.shopxx.controller.admin;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import net.shopxx.Pageable;
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

@Controller("adminMessageController")
@RequestMapping({"/admin/message"})
public class MessageController extends BaseController
{

  @Resource(name="messageServiceImpl")
  MessageService IIIlllIl;

  @Resource(name="memberServiceImpl")
  MemberService IIIllllI;

  @RequestMapping(value={"/check_username"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  @ResponseBody
  public boolean checkUsername(String username)
  {
    return this.IIIllllI.usernameExists(username);
  }

  @RequestMapping(value={"/send"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String send(Long draftMessageId, Model model)
  {
    net.shopxx.entity.Message localMessage = (net.shopxx.entity.Message)this.IIIlllIl.find(draftMessageId);
    if ((localMessage != null) && (localMessage.getIsDraft().booleanValue()) && (localMessage.getSender() == null))
      model.addAttribute("draftMessage", localMessage);
    return "admin/message/send";
  }

  @RequestMapping(value={"/send"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String send(Long draftMessageId, String username, String title, String content, @RequestParam(defaultValue="false") Boolean isDraft, HttpServletRequest request, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(net.shopxx.entity.Message.class, "content", content, new Class[0]))
      return "/admin/common/error";
    net.shopxx.entity.Message localMessage1 = (net.shopxx.entity.Message)this.IIIlllIl.find(draftMessageId);
    if ((localMessage1 != null) && (localMessage1.getIsDraft().booleanValue()) && (localMessage1.getSender() == null))
      this.IIIlllIl.delete(localMessage1);
    Member localMember = null;
    if (StringUtils.isNotEmpty(username))
    {
      localMember = this.IIIllllI.findByUsername(username);
      if (localMember == null)
        return "/admin/common/error";
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
    localMessage2.setSender(null);
    localMessage2.setReceiver(localMember);
    localMessage2.setForMessage(null);
    localMessage2.setReplyMessages(null);
    this.IIIlllIl.save(localMessage2);
    if (isDraft.booleanValue())
    {
      IIIllIlI(redirectAttributes, net.shopxx.Message.success("admin.message.saveDraftSuccess", new Object[0]));
      return "redirect:draft.jhtml";
    }
    IIIllIlI(redirectAttributes, net.shopxx.Message.success("admin.message.sendSuccess", new Object[0]));
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/view"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String view(Long id, Model model)
  {
    net.shopxx.entity.Message localMessage = (net.shopxx.entity.Message)this.IIIlllIl.find(id);
    if ((localMessage == null) || (localMessage.getIsDraft().booleanValue()) || (localMessage.getForMessage() != null))
      return "/admin/common/error";
    if (((localMessage.getSender() != null) && (localMessage.getReceiver() != null)) || ((localMessage.getReceiver() == null) && (localMessage.getReceiverDelete().booleanValue())) || ((localMessage.getSender() == null) && (localMessage.getSenderDelete().booleanValue())))
      return "/admin/common/error";
    if (localMessage.getReceiver() == null)
      localMessage.setReceiverRead(Boolean.valueOf(true));
    else
      localMessage.setSenderRead(Boolean.valueOf(true));
    this.IIIlllIl.update(localMessage);
    model.addAttribute("adminMessage", localMessage);
    return "/admin/message/view";
  }

  @RequestMapping(value={"/reply"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String reply(Long id, String content, HttpServletRequest request, RedirectAttributes redirectAttributes)
  {
    if (!IIIllIlI(net.shopxx.entity.Message.class, "content", content, new Class[0]))
      return "/admin/common/error";
    net.shopxx.entity.Message localMessage1 = (net.shopxx.entity.Message)this.IIIlllIl.find(id);
    if ((localMessage1 == null) || (localMessage1.getIsDraft().booleanValue()) || (localMessage1.getForMessage() != null))
      return "/admin/common/error";
    if (((localMessage1.getSender() != null) && (localMessage1.getReceiver() != null)) || ((localMessage1.getReceiver() == null) && (localMessage1.getReceiverDelete().booleanValue())) || ((localMessage1.getSender() == null) && (localMessage1.getSenderDelete().booleanValue())))
      return "/admin/common/error";
    net.shopxx.entity.Message localMessage2 = new net.shopxx.entity.Message();
    localMessage2.setTitle("reply: " + localMessage1.getTitle());
    localMessage2.setContent(content);
    localMessage2.setIp(request.getRemoteAddr());
    localMessage2.setIsDraft(Boolean.valueOf(false));
    localMessage2.setSenderRead(Boolean.valueOf(true));
    localMessage2.setReceiverRead(Boolean.valueOf(false));
    localMessage2.setSenderDelete(Boolean.valueOf(false));
    localMessage2.setReceiverDelete(Boolean.valueOf(false));
    localMessage2.setSender(null);
    localMessage2.setReceiver(localMessage1.getReceiver() == null ? localMessage1.getSender() : localMessage1.getReceiver());
    if (((localMessage1.getReceiver() == null) && (!localMessage1.getSenderDelete().booleanValue())) || ((localMessage1.getSender() == null) && (!localMessage1.getReceiverDelete().booleanValue())))
      localMessage2.setForMessage(localMessage1);
    localMessage2.setReplyMessages(null);
    this.IIIlllIl.save(localMessage2);
    if (localMessage1.getSender() == null)
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
    if (((localMessage1.getReceiver() == null) && (!localMessage1.getSenderDelete().booleanValue())) || ((localMessage1.getSender() == null) && (!localMessage1.getReceiverDelete().booleanValue())))
    {
      IIIllIlI(redirectAttributes, IIIlllII);
      return "redirect:view.jhtml?id=" + localMessage1.getId();
    }
    IIIllIlI(redirectAttributes, net.shopxx.Message.success("admin.message.replySuccess", new Object[0]));
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(Pageable pageable, Model model)
  {
    model.addAttribute("page", this.IIIlllIl.findPage(null, pageable));
    return "/admin/message/list";
  }

  @RequestMapping(value={"/draft"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String draft(Pageable pageable, Model model)
  {
    model.addAttribute("page", this.IIIlllIl.findDraftPage(null, pageable));
    return "/admin/message/draft";
  }

  @RequestMapping(value={"delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public net.shopxx.Message delete(Long[] ids)
  {
    if (ids != null)
      for (Long localLong : ids)
        this.IIIlllIl.delete(localLong, null);
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.MessageController
 * JD-Core Version:    0.6.2
 */