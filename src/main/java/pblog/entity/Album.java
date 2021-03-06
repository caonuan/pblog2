package pblog.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Scope("prototype")
@Entity
@Table
public class Album {
	private int albumId;
	private String albumName;
	private Date publishDate;
	private String albumUrl;

	public Album() {
	}

	public Album(int albumId, String albumName, Date publishDate, String albumUrl) {
		super();
		this.albumId = albumId;
		this.albumName = albumName;
		this.publishDate = publishDate;
		this.albumUrl = albumUrl;
	}

	@Id
	@GeneratedValue
	@Column(name = "albumId")
	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	@Column(name = "albumName")
	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	@Column(name = "publishDate")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	@Column(name = "albumUrl")
	public String getAlbumUrl() {
		return albumUrl;
	}

	public void setAlbumUrl(String albumUrl) {
		this.albumUrl = albumUrl;
	}

}
