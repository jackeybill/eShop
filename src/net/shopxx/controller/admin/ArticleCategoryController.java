package net.shopxx.controller.admin;

import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import net.shopxx.Message;
import net.shopxx.entity.ArticleCategory;
import net.shopxx.service.ArticleCategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller("adminArticleCategoryController")
@RequestMapping({"/admin/article_category"})
public class ArticleCategoryController extends BaseController
{

  @Resource(name="articleCategoryServiceImpl")
  private ArticleCategoryService IIIlllIl;

  @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String add(ModelMap model)
  {
    model.addAttribute("articleCategoryTree", this.IIIlllIl.findTree());
    return "/admin/article_category/add";
  }

  @RequestMapping(value={"/save"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String save(ArticleCategory articleCategory, Long parentId, RedirectAttributes redirectAttributes)
  {
    articleCategory.setParent((ArticleCategory)this.IIIlllIl.find(parentId));
    if (!IIIllIlI(articleCategory, new Class[0]))
      return "/admin/common/error";
    articleCategory.setTreePath(null);
    articleCategory.setGrade(null);
    articleCategory.setChildren(null);
    articleCategory.setArticles(null);
    this.IIIlllIl.save(articleCategory);
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String edit(Long id, ModelMap model)
  {
    ArticleCategory localArticleCategory = (ArticleCategory)this.IIIlllIl.find(id);
    model.addAttribute("articleCategoryTree", this.IIIlllIl.findTree());
    model.addAttribute("articleCategory", localArticleCategory);
    model.addAttribute("children", this.IIIlllIl.findChildren(localArticleCategory));
    return "/admin/article_category/edit";
  }

  @RequestMapping(value={"/update"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  public String update(ArticleCategory articleCategory, Long parentId, RedirectAttributes redirectAttributes)
  {
    articleCategory.setParent((ArticleCategory)this.IIIlllIl.find(parentId));
    if (!IIIllIlI(articleCategory, new Class[0]))
      return "/admin/common/error";
    if (articleCategory.getParent() != null)
    {
      ArticleCategory localArticleCategory = articleCategory.getParent();
      if (localArticleCategory.equals(articleCategory))
        return "/admin/common/error";
      List localList = this.IIIlllIl.findChildren(localArticleCategory);
      if ((localList != null) && (localList.contains(localArticleCategory)))
        return "/admin/common/error";
    }
    this.IIIlllIl.update(articleCategory, new String[] { "treePath", "grade", "children", "articles" });
    IIIllIlI(redirectAttributes, IIIlllII);
    return "redirect:list.jhtml";
  }

  @RequestMapping(value={"/list"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
  public String list(ModelMap model)
  {
    model.addAttribute("articleCategoryTree", this.IIIlllIl.findTree());
    return "/admin/article_category/list";
  }

  @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
  @ResponseBody
  public Message delete(Long id)
  {
    ArticleCategory localArticleCategory = (ArticleCategory)this.IIIlllIl.find(id);
    if (localArticleCategory == null)
      return IIIllIll;
    Set localSet1 = localArticleCategory.getChildren();
    if ((localSet1 != null) && (!localSet1.isEmpty()))
      return Message.error("admin.articleCategory.deleteExistChildrenNotAllowed", new Object[0]);
    Set localSet2 = localArticleCategory.getArticles();
    if ((localSet2 != null) && (!localSet2.isEmpty()))
      return Message.error("admin.articleCategory.deleteExistArticleNotAllowed", new Object[0]);
    this.IIIlllIl.delete(id);
    return IIIlllII;
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.controller.admin.ArticleCategoryController
 * JD-Core Version:    0.6.2
 */