package pblog.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pblog.dao.ArticleDAO;
import pblog.entity.Article;
import pblog.othertest.HtmlParserTest;

public class ArticleDAOImplTest {
	private ApplicationContext context = null;
	private ArticleDAO adao = null;
	{
		context = new ClassPathXmlApplicationContext("beans.xml");
		adao = (ArticleDAO) context.getBean("articleDAO");
	}

	@Test
	public void addArticleTest() {
		Article article = new Article();
		article.setBlogClassId(1);
		article.setContent("测试2");
		article.setPublishDate(new Date());
		article.setReadCount(0);
		article.setTitle("测速2");
		adao.addArticle(article);
	}
	
	@Test
	public void getArticleByPageTest(){
		List<Article> list=adao.getArticleByPage(1,-1,4);
		for (Article article : list) {
			System.out.println(article.getArticleId());
		}
	}
	
	@Test
	public void getPageCountTest(){
		int page=adao.getArticleCount();
		System.out.println(page);
	}
	
	@Test
	public void getAritleByClassAndPageTest(){
		List<Article> list=adao.getAritleByClassAndPage(2,1,true);
		for (Article article : list) {
			System.out.println(article.getBlogClassId());
		}
	}
	
	
	@Test
	public void gerPageCountForClassTest(){
		int page=adao.getPageCountForClass(1,true);
		System.out.println(page);
	}
	
	@Test
	public void deleteArticleTest(){
		Article a=adao.getArticleById(12);
		adao.deleteArticleById(12);
		System.out.println(a.getTitle());
	}
	
	
	@Test
	public void searchTest(){
		List<Article> list=adao.getArticleByKeyWord("shadowsocks tomcat",1);
		for (Article article : list) {
			System.out.println(article.getArticleId());
		}
	}
	
	@Test
	public void getPTagTest(){
		Article article=adao.getArticleById(30);
		HtmlParserTest.getPTagContent(article.getContent());
	}
	
	@Test
	public void getSearchCountTest(){
		System.out.println(adao.getArticleCountByKeyWord("shadowsocks"));
	}
	
	@Test
	public void getAllMonthsWhichHaveArticleTest(){
		List<Object[]> list=adao.getAllMonthsWhichHaveArticle();
		for (Object[] objects : list) {
			System.out.println(objects[0].toString());
			System.out.println(objects[1]);
		}
	}
}
