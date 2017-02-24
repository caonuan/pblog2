package pblog.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pblog.entity.Album;
import pblog.service.PhotoService;

public class ShowAlbumAction extends ActionSupport{
	private int albumId;
	private int pageNow;
	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	private List<Album> albumList;
	private PhotoService photoService;
	
	@Override
	public String execute() throws Exception {
		albumList = (List<Album>) photoService.getAlbum(pageNow);
		return super.execute();
	}
	
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	

	public PhotoService getPhotoService() {
		return photoService;
	}
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}
	public void setAlbumList(List<Album> albumList) {
		this.albumList = albumList;
	}
	public List<Album> getAlbumList() {
		return albumList;
	}
}
