package net.shopxx.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import net.shopxx.dao.ArticleCategoryDao;
import net.shopxx.dao.ArticleDao;
import net.shopxx.dao.TagDao;
import net.shopxx.entity.Article;
import net.shopxx.entity.ArticleCategory;
import net.shopxx.entity.Tag;
import net.shopxx.entity.Tag.Type;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:/applicationContext.xml", "classpath*:/applicationContext-mvc.xml"})
@Transactional
public class ArticleDaoImplTest
{

  @Resource(name="articleCategoryDaoImpl")
  private ArticleCategoryDao IIIllIlI;

  @Resource(name="tagDaoImpl")
  private TagDao IIIllIll;

  @Resource(name="articleDaoImpl")
  private ArticleDao IIIlllII;
  private static final Logger IIIlllIl = LoggerFactory.getLogger(ArticleDaoImplTest.class);
  private static Long[] IIIllllI = new Long[100];
  private static Long[] IIIlllll = new Long[100];
  private static Long[] IIlIIIII = new Long[20];

  @Before
  public void prepareTestData()
  {
    String str;
    Object localObject;
    for (int i = 0; i < IIIllllI.length; i++)
    {
      str = "test" + i;
      localObject = new ArticleCategory();
      if (i < 20)
      {
        ((ArticleCategory)localObject).setName(str);
        ((ArticleCategory)localObject).setOrder(Integer.valueOf(i));
        this.IIIllIlI.persist(localObject);
      }
      else
      {
        ((ArticleCategory)localObject).setName(str);
        ((ArticleCategory)localObject).setOrder(Integer.valueOf(i));
        ((ArticleCategory)localObject).setParent((ArticleCategory)this.IIIllIlI.find(IIIllllI[0]));
        this.IIIllIlI.persist(localObject);
      }
      IIIllllI[i] = ((ArticleCategory)localObject).getId();
    }
    this.IIIllIlI.flush();
    this.IIIllIlI.clear();
    for (i = 0; i < IIlIIIII.length; i++)
    {
      str = "test" + i;
      localObject = new Tag();
      ((Tag)localObject).setName(str);
      ((Tag)localObject).setOrder(Integer.valueOf(i));
      ((Tag)localObject).setType(Tag.Type.article);
      this.IIIllIll.persist(localObject);
      IIlIIIII[i] = ((Tag)localObject).getId();
    }
    this.IIIllIll.flush();
    this.IIIllIll.clear();
    for (i = 0; i < IIIlllll.length; i++)
    {
      str = "test" + i;
      localObject = new Article();
      ((Article)localObject).setTitle(str);
      ((Article)localObject).setContent(str);
      ((Article)localObject).setIsPublication(Boolean.valueOf(true));
      ((Article)localObject).setIsTop(Boolean.valueOf(false));
      ((Article)localObject).setHits(Long.valueOf(0L));
      if (i < 20)
        ((Article)localObject).setArticleCategory((ArticleCategory)this.IIIllIlI.find(IIIllllI[0]));
      else
        ((Article)localObject).setArticleCategory((ArticleCategory)this.IIIllIlI.find(IIIllllI[1]));
      if (i < 20)
      {
        HashSet localHashSet = new HashSet();
        if (i < 10)
        {
          localHashSet.add((Tag)this.IIIllIll.find(IIlIIIII[0]));
          localHashSet.add((Tag)this.IIIllIll.find(IIlIIIII[1]));
        }
        localHashSet.add((Tag)this.IIIllIll.find(IIlIIIII[2]));
        ((Article)localObject).setTags(localHashSet);
      }
      this.IIIlllII.persist(localObject);
      IIIlllll[i] = ((Article)localObject).getId();
    }
    this.IIIlllII.flush();
    this.IIIlllII.clear();
    IIIlllIl.info("prepare test data");
  }

  @Test
  public void testFindList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add((Tag)this.IIIllIll.find(IIlIIIII[0]));
    localArrayList.add((Tag)this.IIIllIll.find(IIlIIIII[2]));
    MatcherAssert.assertThat(Integer.valueOf(this.IIIlllII.findList(null, localArrayList, null, null, null).size()), Matchers.is(Integer.valueOf(80)));
  }
}

/* Location:           C:\jackey\software\jad\
 * Qualified Name:     net.shopxx.test.ArticleDaoImplTest
 * JD-Core Version:    0.6.2
 */