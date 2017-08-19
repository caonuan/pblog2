package pblog.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Scope("prototype")
@Entity
@Table
public class AlbumReply {

	private int albumReplyId;
	private String content;
	private Date publishTime;
	private int visitorId;
	private int receiveId;
	private int albumId;

	public AlbumReply() {
	}

	public AlbumReply(int albumReplyId, String content, Date publishTime, int visitorId, int receiveId, int albumId) {
		super();
		this.albumReplyId = albumReplyId;
		this.content = content;
		this.publishTime = publishTime;
		this.visitorId = visitorId;
		this.receiveId = receiveId;
		this.albumId = albumId;
	}

	@Id
	@GeneratedValue
	@Column(name = "albumReplyId")
	public int getAlbumReplyId() {
		return albumReplyId;
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

	public void setAlbumReplyId(int albumReplyId) {
		this.albumReplyId = albumReplyId;
	}

	@Column(name = "receiveId")
	public int getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(int receiveId) {
		this.receiveId = receiveId;
	}

	@Column(name = "albumId")
	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

}
