package pblog.service;

import pblog.entity.AlbumReply;
import pblog.entity.ArticleReply;

import java.util.List;

public interface ReplyService {
	/**
	 * 添加博文评论.
	 * @param content
	 * @param visitorId 访客id
	 * @param receiveId 博主默认为0！即访客发表评论是，接收人为博主——>0
	 * @param arcitleId
	 * @return
	 */
	public String addArticleReply(String content,int visitorId,int receiveId,int articleId);
	
	/**
	 * 添加相册评论.
	 * @param content
	 * @param visitorId 访客id
	 * @param receiveId 博主默认为0！即访客发表评论是，接收人为博主——>0
	 * @param albumId
	 * @return
	 */
	public String addAlbumReply(String content,int visitorId,int receiveId,int albumId);
	
	/**
	 * 删除单条博文评论
	 * @param articleReplyId
	 * @return
	 */
	public String deleteArticleReply(int articleReplyId);

	/**
	 * 删除单条相册评论
	 * @param albumReplyId
	 * @return
	 */
	public String deleteAlbumReply(int albumReplyId);
	
	public List<ArticleReply> getArticleReplys(int articleId);

	public List<AlbumReply> getAlbumReplys(int albumId);
}
