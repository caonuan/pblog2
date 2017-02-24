package pblog.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pblog.entity.Article;
import pblog.service.ArticleService;

public class ArticleServiceTest {
	ArticleService as;

	private ApplicationContext context = null;
	{
		context = new ClassPathXmlApplicationContext("beans.xml");
		as = (ArticleService) context.getBean("articleService");
	}

	@Test
	public void addArticleTest() {
		as.addArticle("ceshi", 1, "ceshi",0,0);
	}
	
	@Test
	public void getSomeArticleTest(){
		List<Article> list = as.getSomeArticle(2,10,-1);
		System.out.println(list.size());
		for (Article article : list) {
			System.out.println(article.getArticleId());
		}
	}
	

	@Test
	public void managerGetSomeArticleTest() {
		List<Article> list = as.managerGetSomeArticle(1,10,-1);
		System.out.println(list.size());
		for (Article article : list) {
			System.out.println(article.getArticleId());
		}
	}
	
	@Test
	public void deleteArticleTest(){
		as.deleteArticle(20);
	}
}
