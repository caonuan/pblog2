package pblog.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pblog.dao.ArticleDAO;
import pblog.entity.Article;
import pblog.entity.BlogClass;
import pblog.service.ArticleService;
import pblog.util.Util;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	private ArticleDAO articleDAO;

	public ArticleDAO getArticleDAO() {
		return articleDAO;
	}

	@Resource
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	public String addArticle(String title, int blogClassId, String content,
			int topPost, int hidden) {
		Article article = new Article(title, blogClassId, content, new Date(), null,
				0, topPost, hidden);
		articleDAO.addArticle(article);
		return "success";
	}

	@Override
	public String updateArticle(int articleId, String title, int blogClassId,
			String content, int topPost, int hidden) {
		Article article = articleDAO.getArticleById(articleId);
		article.setTitle(title);
		article.setBlogClassId(blogClassId);
		article.setContent(content);
		article.setUpdateDate(new Date());
		article.setTopPost(topPost);
		article.setHidden(hidden);
		articleDAO.updateArticle(article);
		return "success";
	}

	@Override
	public List<Article> getSomeArticle(int page,int size,int firstResult) {
		List<Article> list = articleDAO.getArticleByPage(page,size,firstResult);
		return list;
	}

	@Override
	public List<Article> managerGetSomeArticle(int page,int size,int firstResult) {
		List<Article> list = articleDAO.managerGetArticleByPage(page,size,firstResult);
		return list;
	}

	@Override
	public List<Article> getAritleByClassAndPage(int blogClassId, int page) {
		List<Article> list = articleDAO.getAritleByClassAndPage(blogClassId, page);
		return list;
	}

	@Override
	public Article getOneArticle(int articleId) {
		Article article = articleDAO.getArticleById(articleId);
		if (article != null) {
			article.setReadCount(article.getReadCount() + 1);
			articleDAO.updateArticle(article);
		}
		return article;
	}

	@Override
	public String deleteArticle(int articleId) {
		Article article = articleDAO.getArticleById(articleId);
		String content = article.getContent();

		String regex;
		List<String> list = new ArrayList<String>();
		regex = "src=\"(.*?)\"";
		Pattern pa = Pattern.compile(regex, Pattern.DOTALL);
		Matcher ma = pa.matcher(content);
		while (ma.find()) {
			list.add(ma.group());
		}
		boolean deleteflag = true;
		for (String string : list) {
			int begin = string.indexOf("\"") + 1;
			int end = string.lastIndexOf("\"");
			boolean onedeleteflag = Util
					.deleteFileBySrc(string.substring(begin, end));
			if (!onedeleteflag)
				deleteflag = false;
		}
		boolean ifsuccess = false;
		if (deleteflag)
			ifsuccess = articleDAO.deleteArticleById(articleId);
		return ifsuccess ? "success" : "delete_error";
	}

	@Override
	public String saveReadCount(Article article) {
		article.setReadCount(article.getReadCount() + 1);
		boolean flag = articleDAO.updateArticle(article);
		return flag ? "success" : "error";
	}

	@Override
	public int getPageCount(int size) {
		int count = articleDAO.getArticleCount();
		return (count % size == 0) ? (count / size) : (count / size + 1);
	}
	
	@Override
	public int managerGetPageCount(int size) {
		int count = articleDAO.managerGetArticleCount();
		return (count % size == 0) ? (count / size) : (count / size + 1);
	}

	
	@Override
	public int getPageCountForClass(int blogClassId) {
		int size = articleDAO.getPageCountForClass(blogClassId);
		return (size % 10 == 0) ? (size / 10) : (size / 10 + 1);
	}

	@Override
	public List<BlogClass> getAllBlogClass() {
		List<BlogClass> list = articleDAO.getAllBlogClass();
		return list;
	}

	@Override
	public BlogClass getBlogClassById(int blogClassId) {
		BlogClass blogClass = articleDAO.getBlogClassByBlogClassId(blogClassId);
		return blogClass;
	}

	@Override
	public List<Object[]> getAllMonthsWhichHaveArticle() {
		return articleDAO.getAllMonthsWhichHaveArticle();
	}

	@Override
	public List<Article> getArticlesByTime(String time) {
		return articleDAO.getArticlesByTime(time);
	}
	
	@Override
	public List<Article> getTopPostedArticle() {
		return articleDAO.getTopPostedArticle();
	}
}
