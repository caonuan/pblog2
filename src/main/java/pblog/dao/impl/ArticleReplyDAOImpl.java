package pblog.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import pblog.dao.ArticleReplyDAO;
import pblog.entity.ArticleReply;

import java.io.Serializable;
import java.util.List;
@Component("articleReplyDAO")
public class ArticleReplyDAOImpl implements ArticleReplyDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public ArticleReply getByArticleReplyId(int articleReplyId) {
		ArticleReply articleReply=hibernateTemplate.get(ArticleReply.class, articleReplyId);
		return articleReply;
	}

	@Override
	public List<ArticleReply> getAllArticleReply(int articleId) {
		List<ArticleReply> list=(List<ArticleReply>) hibernateTemplate.find("from pblog.entity.ArticleReply a where a.articleId=?", articleId);
		return list;
	}

	@Override
	public boolean addArticleReply(ArticleReply articleReply) {
		Serializable s=hibernateTemplate.save(articleReply);
		if(s!=null){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteArticleReply(int articleReplyId) {
		ArticleReply articleReply=hibernateTemplate.get(ArticleReply.class, articleReplyId);
		hibernateTemplate.delete(articleReply);
		return true;
	}

	@Override
	public boolean deleteAllArticleReply(int articleId) {
		List<ArticleReply> list=this.getAllArticleReply(articleId);
		hibernateTemplate.deleteAll(list);
		return true;
	}

}
