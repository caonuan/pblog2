package pblog.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import pblog.dao.ArticleDAO;
import pblog.entity.Article;
import pblog.entity.ArticleReply;
import pblog.entity.BlogClass;

@Component("articleDAO")
public class ArticleDAOImpl implements ArticleDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public Article getArticleById(int articleId) {
		Article article = hibernateTemplate.get(Article.class, articleId);
		return article;
	}

	@Override
	public List<Article> getArticleByPage(final int page,final int size,int firstResult) {
		final int firstResultNum;
		if(firstResult==-1){
			firstResultNum=(page - 1) * size;
		}else{
			firstResultNum=firstResult;
		}
		@SuppressWarnings("unchecked")
		List<Article> list = (List<Article>) hibernateTemplate
				.execute(new HibernateCallback<Object>() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(
								"from Article where topPost!=1 and hidden!=1 order by publishDate desc");
						query.setMaxResults(size);
						query.setFirstResult(firstResultNum);
						return query.list();
					}
				});
		return list;
	}
	
	@Override
	public List<Article> managerGetArticleByPage(final int page,final int size,int firstResult) {
		final int firstResultNum;
		if(firstResult==-1){
			firstResultNum=(page - 1) * size;
		}else{
			firstResultNum=firstResult;
		}
		@SuppressWarnings("unchecked")
		List<Article> list = (List<Article>) hibernateTemplate
				.execute(new HibernateCallback<Object>() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery(
								"from Article order by publishDate desc");
						query.setMaxResults(size);
						query.setFirstResult(firstResultNum);
						return query.list();
					}
				});
		return list;
	}

	@Override
	public int getArticleCount() {
		Long n = (Long) hibernateTemplate
				.find("select count(articleId) from pblog.entity.Article where topPost!=1 and hidden!=1").get(0);
		return n.intValue();
	}
	
	@Override
	public int managerGetArticleCount() {
		Long n = (Long) hibernateTemplate
				.find("select count(articleId) from pblog.entity.Article").get(0);
		return n.intValue();
	}

	@Override
	public List<Article> getArticleByKeyWord(final String keyWord,
			final int pageNow) {
		@SuppressWarnings("unchecked")
		List<Object[]> objlist = (List<Object[]>) hibernateTemplate
				.execute(new HibernateCallback<Object>() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session
								.createSQLQuery(
										"select * from Article where hidden!=1 and match (title,content) against (?) limit ?,?")
								.setParameter(0, keyWord)
								.setParameter(1, (pageNow - 1) * 10)
								.setParameter(2, pageNow * 10);
						return query.list();
					}
				});
		List<Article> list = new ArrayList<>();
		for (Object[] objects : objlist) {
			Article article = new Article();
			int i = 0;
			article.setArticleId((int) objects[i++]);
			article.setBlogClassId((int) objects[i++]);
			article.setContent((String) objects[i++]);
			article.setPublishDate((java.util.Date) objects[i++]);
			article.setReadCount((int) objects[i++]);
			article.setTitle((String) objects[i++]);
			article.setUpdateDate((java.util.Date) objects[i++]);
			list.add(article);
		}
		return list;
	}

	@Override
	public int getArticleCountByKeyWord(final String keyWord) {
		@SuppressWarnings("unchecked")
		List<BigInteger> count = (List<BigInteger>) hibernateTemplate
				.execute(new HibernateCallback<Object>() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session
								.createSQLQuery(
										"select count(*) from Article where hidden!=1 and match (title,content) against (?) ")
								.setParameter(0, keyWord);
						return query.list();
					}
				});
		int pageCount = count.get(0).intValue() / 10 + 1;
		return pageCount;
	}

	@Override
	public List<Article> getAritleByClassAndPage(final int blogClassId,
			final int page,final boolean ifShowHidden) {
		@SuppressWarnings("unchecked")
		List<Article> list = (List<Article>) hibernateTemplate
				.execute(new HibernateCallback<Object>() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException {
						if(!ifShowHidden)
							session.enableFilter("hiddenFilter");
						Query query = session
								.createQuery("from Article where blogClassId =? order by publishDate desc")
								.setParameter(0, blogClassId);
						query.setMaxResults(10);
						query.setFirstResult((page - 1) * 10);
						return query.list();
					}
				});
		return list;
	}

	@Override
	public int getPageCountForClass(int blogClassId,boolean ifShowHidden) {
		String sql;
		if(ifShowHidden)
			sql="select count(articleId) from pblog.entity.Article where blogClassId = ?";
		else
			sql="select count(articleId) from pblog.entity.Article where blogClassId = ? and hidden!=1";
		Long n = (Long) hibernateTemplate
				.find(sql,
						blogClassId)
				.get(0);
		return n.intValue();
	}

	@Override
	public boolean addArticle(Article article) {
		Serializable s = hibernateTemplate.save(article);
		if (s != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteArticleById(int articleId) {
		Article article = hibernateTemplate.get(Article.class, articleId);
		hibernateTemplate.delete(article);
		@SuppressWarnings("unchecked")
		List<ArticleReply> articleReplyList = (List<ArticleReply>) hibernateTemplate
				.find("from ArticleReply where articleId=?", articleId);
		hibernateTemplate.deleteAll(articleReplyList);
		if (article != null)
			return true;
		return false;
	}

	@Override
	public boolean updateArticle(Article article) {
		hibernateTemplate.update(article);
		return true;
	}

	@Override
	public List<BlogClass> getAllBlogClass() {
		@SuppressWarnings("unchecked")
		List<BlogClass> list = (List<BlogClass>) hibernateTemplate
				.find("from BlogClass");
		return list;
	}

	@Override
	public BlogClass getBlogClassByBlogClassId(int blogClassId) {
		BlogClass blogClass = hibernateTemplate.get(BlogClass.class, blogClassId);
		return blogClass;
	}

	@Override
	public List<Object[]> getAllMonthsWhichHaveArticle() {
		@SuppressWarnings("unchecked")
		List<Object[]> list = (List<Object[]>) hibernateTemplate
				.execute(new HibernateCallback<Object>() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createSQLQuery(
								"select substr(publishDate,1,7),count(articleId) from Article group by substr(publishDate,1,7)");
						return query.list();
					}
				});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getArticlesByTime(String time){
		return (List<Article>) hibernateTemplate.find("from Article where SUBSTR(publishDate,1,7)=? and hidden!=1 order by publishDate desc", time);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getTopPostedArticle(){
		return (List<Article>) hibernateTemplate.find("from Article where topPost=1 and hidden!=1");
	}
}
