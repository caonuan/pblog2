package pblog.dao;

import java.util.List;

import pblog.entity.ArticleReply;

public interface ArticleReplyDAO {
	/**
	 * 通过博文评论id寻找评论
	 * @param articleReplyId 博文评论id
	 * @return 博文评论
	 */
	public ArticleReply getByArticleReplyId(int articleReplyId);
	
	/**
	 * 通过博文id寻找所有此博文的评论
	 * @param articleId 博文id
	 * @return
	 */
	public List<ArticleReply> getAllArticleReply(int articleId);
	
	/**
	 * 添加博文评论
	 * @param articleReply
	 * @return
	 */
	public boolean addArticleReply(ArticleReply articleReply);

	/**
	 * 通过评论id删除评论。管理员调用。
	 * @param articleReply
	 * @return 是否成功
	 */
	public boolean deleteArticleReply(int articleReplyId);
	
	/**
	 * 删除某博文的所有评论，可调用getAllArticleReply方法。
	 * @param articleId 博文id
	 * @return 是否成功
	 */
	public boolean deleteAllArticleReply(int articleId);
}
