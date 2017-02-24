package pblog.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import pblog.entity.Photo;
import pblog.service.PhotoService;

@Controller
@Scope("prototype")
public class ShowPhotoForAlbumAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4861030352497197335L;
	private int albumId;
	private List<Photo> photoList;
	private PhotoService photoService;

	@Override
	public String execute() throws Exception {
		photoList = photoService.getAlbumPhoto(albumId);
		for (Photo photo : photoList) {
			photo.setUrl(
					photo.getUrl().substring(0, photo.getUrl().lastIndexOf('.'))
							+ "_t"
							+ photo.getUrl().substring(
									photo.getUrl().lastIndexOf('.'), photo.getUrl()
											.length()));
		}
		return SUCCESS;
	}

	public PhotoService getPhotoService() {
		return photoService;
	}

	@Resource
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public List<Photo> getPhotoList() {
		return photoList;
	}

	public void setPhotoList(List<Photo> photoList) {
		this.photoList = photoList;
	}

}
