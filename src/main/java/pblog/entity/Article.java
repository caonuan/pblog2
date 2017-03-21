package pblog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table
//hibernate过滤器，当过滤器enable时，筛选出不隐藏的博文。此功能用于管理员通过博客类型浏览博文列表时显示隐藏博客
@FilterDef(name="hiddenFilter")
@Filter(name="hiddenFilter",condition="hidden!=1")
public class Article {
	private int articleId;
	private String title;
	private int blogClassId;
	private String content;
	private Date publishDate;
	private Date updateDate;
	private int readCount;
	private int topPost;
	private int hidden;

	public Article() {
	}

	public Article(int articleId, String title, int blogClassId, String content,
			Date publishDate, Date updateDate, int readCount, int topPost,
			int hidden) {
		super();
		this.articleId = articleId;
		this.title = title;
		this.blogClassId = blogClassId;
		this.content = content;
		this.publishDate = publishDate;
		this.updateDate = updateDate;
		this.readCount = readCount;
		this.topPost = topPost;
		this.hidden = hidden;
	}

	public Article(String title, int blogClassId, String content, Date publishDate,
			Date updateDate, int readCount, int topPost, int hidden) {
		super();
		this.title = title;
		this.blogClassId = blogClassId;
		this.content = content;
		this.publishDate = publishDate;
		this.updateDate = updateDate;
		this.readCount = readCount;
		this.topPost = topPost;
		this.hidden = hidden;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "articleId")
	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "blogClassId")
	@JoinColumn(name = "blogClassId", unique = true)
	public int getBlogClassId() {
		return blogClassId;
	}

	public void setBlogClassId(int blogClassId) {
		this.blogClassId = blogClassId;
	}

	@Column(name = "content", columnDefinition = "text")
	@Type(type = "text")
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

	@Column(name = "updateDate")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "readCount")
	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Column(name = "topPost")
	public int getTopPost() {
		return topPost;
	}

	public void setTopPost(int topPost) {
		this.topPost = topPost;
	}

	@Column(name = "hidden")
	public int getHidden() {
		return hidden;
	}

	public void setHidden(int hidden) {
		this.hidden = hidden;
	}

}
