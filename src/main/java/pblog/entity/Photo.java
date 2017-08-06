package pblog.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pblog.util.Util;

@Component
@Scope("prototype")
@Entity
@Table
public class Photo {
	private int photoId;
	private String photoName;
	private String url;
	private Date publishDate;
	private int albumId;
	@Transient
	private String tUrl;

	public Photo() {
	}

	public Photo(int photoId, String photoName, String url, Date publishDate, int albumId) {
		super();
		this.photoId = photoId;
		this.photoName = photoName;
		this.url = url;
		this.publishDate = publishDate;
		this.albumId = albumId;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "photoId")
	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "publishDate")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Column(name = "albumId")
	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	@Column(name = "photoName")
	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String gettUrl() {
		return Util.get_t_url(getUrl());
	}

	public void settUrl(String tUrl) {
		this.tUrl = tUrl;
	}
}
