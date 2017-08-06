package pblog.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import pblog.dao.AlbumDAO;
import pblog.dao.PhotoDAO;
import pblog.entity.Album;
import pblog.entity.Photo;
import pblog.service.PhotoService;
import pblog.util.SingleApplicationContext;
import pblog.util.Util;

@Service("photoService")
public class PhotoServiceImpl implements PhotoService {
	private PhotoDAO photoDAO;
	private AlbumDAO albumDAO;

	public PhotoDAO getPhotoDAO() {
		return photoDAO;
	}

	@Resource
	public void setPhotoDAO(PhotoDAO photoDAO) {
		this.photoDAO = photoDAO;
	}

	public AlbumDAO getAlbumDAO() {
		return albumDAO;
	}

	@Resource
	public void setAlbumDAO(AlbumDAO albumDAO) {
		this.albumDAO = albumDAO;
	}

	@Override
	public String createAlbum(String albumName, String albumUrl) {
		Album album = (Album) SingleApplicationContext.getApplicationContext()
				.getBean("album");
		album.setAlbumName(albumName);
		album.setAlbumUrl(albumUrl);
		album.setPublishDate(new Date());
		try {
			boolean databaseFlag = albumDAO.createAlbum(album);
			// String src =
			// "C:/Users/Caonuan/Documents/workspace-sts-3.7.3.RELEASE/pblog2/src/main/webapp/pblog/userfiles/files/"
			// + albumName;
			// String src =
			// "/alidata/server/tomcat-7.0.54/webapps/pblog2/userfiles/files/" +
			// albumName;
			String basepath = ServletActionContext.getServletContext()
					.getRealPath("/");
			String src = basepath + "../pblog/userfiles/files/"
					+ album.getAlbumName();
			System.out.println("创建相册本地地址" + src);
			boolean fileFlag = Util.createFileBySrc(src);
			return databaseFlag && fileFlag ? "success" : "error";
		} catch (IOException e) {
			// albumDAO.deleteAlbum(album.getAlbumId());
		}
		return "error";
	}

	@Override
	public String addAlbumPhoto(String name, String url, int albumId) {
		Photo photo = (Photo) SingleApplicationContext.getApplicationContext()
				.getBean("photo");
		photo.setPhotoName(name);
		photo.setUrl(url);
		photo.setAlbumId(albumId);
		photo.setPublishDate(new Date());
		boolean photoflag = photoDAO.addPhoto(photo);
		return photoflag ? "success" : "error";
	}

	@Override
	public String updateAlbum(int albumId, String name, String albumUrl) {
		Album album = albumDAO.getAlbumById(albumId);
		album.setAlbumName(name);
		album.setAlbumUrl(albumUrl);
		boolean databaseflag = albumDAO.updateAlbum(album);
		return databaseflag ? "success" : "error";
	}

	@Override
	public String deleteAlbum(int albumId) {
		Album album = albumDAO.getAlbumById(albumId);
		Util.getPath();
		// String src =
		// "C:/Users/Caonuan/Documents/workspace-sts-3.7.3.RELEASE/pblog2/src/main/webapp/pblog/userfiles/files/"
		// + album.getAlbumName();
		String basepath = ServletActionContext.getServletContext().getRealPath("/");
		String src = basepath + "../pblog/userfiles/files/" + album.getAlbumName();
		String src_t = src.substring(0, src.lastIndexOf('.')) + "_t"
				+ src.substring(src.lastIndexOf('.'), src.length());
		boolean fileflag = Util.deleteFileBySrc(src);
		boolean file_tflag = Util.deleteFileBySrc(src_t);
		if (fileflag == true || file_tflag == true) {
			albumDAO.deleteAlbum(albumId);
		}
		return fileflag ? "success" : "error";
	}

	@Override
	public String deletePhoto(int photoId) {
		Photo photo = photoDAO.getPhotoById(photoId);
		String basepath = ServletActionContext.getServletContext().getRealPath("/");
		boolean fileflag = Util.deleteFileBySrc(basepath + "../" + photo.getUrl());
		boolean databaseflag = false;
		if (fileflag) {
			photoDAO.deletePhotoById(photoId);
		}
		return databaseflag && fileflag ? "success" : "error";
	}

	@Override
	public Album getAlbum(int albumId) {
		return albumDAO.getAlbumById(albumId);
	}

	@Override
	public List<String> getSmallPhoto(int albumId) {
		return null;
	}

	@Override
	public String getPhotoUrlById(int photoId) {
		return photoDAO.getPhotoById(photoId).getUrl();
	}

	@Override
	public List<Album> getAllAlbum() {
		List<Album> list = albumDAO.getAllAblum();
		for (Album album : list) {
			if (album.getAlbumUrl() == null || album.getAlbumUrl().equals("")) {
				Photo selectphoto = getTopPhotoForAlbum(album.getAlbumId());
				album.setAlbumUrl(selectphoto == null ? null : Util.get_t_url(selectphoto.getUrl()));
			}
		}
		return list;
	}

	@Override
	public List<Photo> getTopFivePhoto() {
		List<Photo> list = photoDAO.getPhotoByPage(1);
		return list;
	}

	@Override
	public Photo getTopPhotoForAlbum(int albumId) {
		Photo photo = albumDAO.getTopPhoto(albumId);
		return photo;
	}

	@Override
	public List<Photo> getAlbumPhoto(int albumId) {
		List<Photo> list = albumDAO.getAllPhoto(albumId);
		return list;
	}

	@Override
	public List<Photo> getTopThreePhoto(int albumId) {
		List<Photo> list = albumDAO.getTopThreePhoto(albumId);
		return list;
	}
}
