package pblog.action;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import pblog.service.PhotoService;

@Controller
@Scope("prototype")
public class ManageAlbumAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1963330866898901679L;
	private String albumName;
	private String albumUrl;
	private int albumId;

	private PhotoService photoService;

	public String createAlbum() {
		return photoService.createAlbum(albumName, null);
	}

	public String updateAlbum() {
		return photoService.updateAlbum(albumId, albumName, null);
	}

	public String deleteAlbum() {
		return photoService.deleteAlbum(albumId);
	}

	public PhotoService getPhotoService() {
		return photoService;
	}

	@Resource
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getAlbumUrl() {
		return albumUrl;
	}

	public void setAlbumUrl(String albumUrl) {
		this.albumUrl = albumUrl;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

}
