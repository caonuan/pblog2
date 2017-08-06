package pblog.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import pblog.entity.Album;
import pblog.entity.Photo;
import pblog.service.PhotoService;

@Controller
@Scope("prototype")
@Namespace("/album")
/**
 * 列出相册列表
 * @author Caonuan
 *
 */
public class AlbumAction extends BasicAction {
    private static final long serialVersionUID = 6118167327473682710L;
    private int albumId;
    private int pageNow;

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    private List<Album> albumList;
    private List<Photo> photoList;
    private PhotoService photoService;

    @Action(value = "viewAlbum", results = {
            @Result(name = "success", location = "/album/viewAlbum.jsp")
    })
    public String viewAlbum() throws Exception {
        albumList = (List<Album>) photoService.getAllAlbum();
        return super.execute();
    }

    @Action(value = "showAlbum", results = {
            @Result(name = "success", location = "/album/showAlbum.jsp")
    })
    public String showAlbum() throws Exception {
        photoList = photoService.getAlbumPhoto(albumId);
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

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }
}
