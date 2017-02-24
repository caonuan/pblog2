package pblog.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pblog.dao.AlbumReplyDAO;
import pblog.dao.ArticleReplyDAO;
import pblog.entity.AlbumReply;
import pblog.entity.ArticleReply;
import pblog.service.ReplyService;

@Service("replyService")
public class ReplayServiceImpl implements ReplyService {

	private AlbumReplyDAO albumReplyDAO;
	private ArticleReplyDAO articleReplyDAO;

	public AlbumReplyDAO getAlbumReplyDAO() {
		return albumReplyDAO;
	}

	@Resource
	public void setAlbumReplyDAO(AlbumReplyDAO albumReplyDAO) {
		this.albumReplyDAO = albumReplyDAO;
	}

	public ArticleReplyDAO getArticleReplyDAO() {
		return articleReplyDAO;
	}

	@Resource
	public void setArticleReplyDAO(ArticleReplyDAO articleReplyDAO) {
		this.articleReplyDAO = articleReplyDAO;
	}

	@Override
	public String addArticleReply(String content, int visitorId, int receiveId, int articleId) {
		ArticleReply articleReply = new ArticleReply();
		articleReply.setContent(content);
		articleReply.setVisitorId(visitorId);
		articleReply.setReceiveId(receiveId);
		articleReply.setArticleId(articleId);
		articleReply.setPublishTime(new Date());

		if (articleReplyDAO.addArticleReply(articleReply)) {
			return "success";
		}
		return "error";
	}

	@Override
	public String addAlbumReply(String content, int visitorId, int receiveId, int albumId) {
		AlbumReply albumReply = new AlbumReply();
		albumReply.setAlbumId(albumId);
		albumReply.setContent(content);
		albumReply.setPublishTime(new Date());
		albumReply.setReceiveId(receiveId);
		albumReply.setVisitorId(visitorId);

		if (albumReplyDAO.addAlbumReply(albumReply)  ) {
			return "success";
		}
		return "error";
	}

	@Override
	public String deleteArticleReply(int articleReplyId) {
		if (articleReplyDAO.deleteArticleReply(articleReplyId)  ) {
			return "success";
		}
		return "error";
	}

	@Override
	public String deleteAlbumReply(int albumReplyId) {
		if (albumReplyDAO.deleteAlbumReply(albumReplyId)) {
			return "success";
		}
		return "error";
	}

	@Override
	public List<ArticleReply> getArticleReplys(int articleId) {
		List<ArticleReply> list = articleReplyDAO.getAllArticleReply(articleId);
		return list;
	}

	@Override
	public List<AlbumReply> getAlbumReplys(int albumId) {
		List<AlbumReply> list = albumReplyDAO.getAllAblumReply(albumId);
		return list;
	}

}
