package pblog.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Scope("prototype")
@Entity
@Table
public class ArticleReply {

	private int articleReplyId;
	private String content;
	private Date publishTime;
	private int visitorId;
	private int receiveId;
	private int articleId;

	public ArticleReply() {
	}

	public ArticleReply(int articleReplyId, String content, Date publishTime, int visitorId, int receiveId,
			int articleId) {
		super();
		this.articleReplyId = articleReplyId;
		this.content = content;
		this.publishTime = publishTime;
		this.visitorId = visitorId;
		this.receiveId = receiveId;
		this.articleId = articleId;
	}

	@Id
	@GeneratedValue
	@Column(name = "articleReplyId")
	public int getArticleReplyId() {
		return articleReplyId;
	}

	public void setArticleReplyId(int articleReplyId) {
		this.articleReplyId = articleReplyId;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "publishTime")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	@Column(name = "visitorId")
	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	@Column(name = "receiveId")
	public int getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}

	@Column(name = "articleId")
	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

}
