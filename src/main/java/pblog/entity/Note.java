package pblog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table
public class Note {

	private int noteId;
	private String content;
	private Date publishDate;
	private int visitorId; // �൱��sendId
	private int receiveId;
	private Visitor visitor;

	public Note() {
	}

	public Note(int noteId, String content, Date publishDate, int visitorId,
			int receiveId) {
		super();
		this.noteId = noteId;
		this.content = content;
		this.publishDate = publishDate;
		this.visitorId = visitorId;
		this.receiveId = receiveId;
	}

	@Id
	@GeneratedValue
	@Column(name = "noteId")
	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	@Column(name = "content")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "publishDate")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
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

	@ManyToOne
	@Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "visitorId",insertable=false,updatable=false)
	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

}
