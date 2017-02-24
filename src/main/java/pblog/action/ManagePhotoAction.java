package pblog.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import pblog.entity.Album;
import pblog.service.PhotoService;
import pblog.util.AffineTransImage;

@Controller
@Scope("prototype")
public class ManagePhotoAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7111950921885938095L;

	private static final int BUFFER_SIZE = 16 * 1024;
	// 注意，文件上传时<s:file/>同时与myFile，myFileContentType,myFileFileName绑定
	// 所以同时要提供myFileContentType,myFileFileName的set方法

	private File myFile; // 上传文件
	private String contentType;// 上传文件类型
	private String fileName; // 上传文件名
	private String imageFileName;
	private String photoName;
	private PhotoService photoService;
	private Map<Integer, String> albumMap;
	private int albumId;//选中的相册Id
	private String url;//图片最终url地址
	private int photoId;

	private static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}

	public String addPhotoResult() {
		imageFileName = new Date().getTime() + getExtention(fileName);
		photoName = photoName.equals("") ? fileName.substring(0, fileName.indexOf(".")) : photoName;
		String albumName = photoService.getAlbum(albumId).getAlbumName();
		url = "/pblog/userfiles/files/" + albumName + "/" + imageFileName;
		String basepath=ServletActionContext.getServletContext().getRealPath("/");
		// 判断以相册名为名的图片文件夹是否存在，不存在则创建
		File albumFile = new File(basepath+ "../pblog/userfiles/files/" + albumName);
		if(!albumFile.exists())
			albumFile.mkdirs();
		File imageFile = new File(basepath +"../"+ url);
		System.out.println("添加图片路径："+basepath+ "../"+url);
		copy(myFile, imageFile);
		//生成压缩图片
		AffineTransImage.makeThumbnail(basepath+ "../"+url);
		photoService.addAlbumPhoto(photoName, url, albumId);
		return SUCCESS;
	}

	public String addPhoto() {
		List<Album> albumList = photoService.getAllAlbum();
		albumMap = new HashMap<Integer, String>();
		for (Album album : albumList) {
			albumMap.put(album.getAlbumId(), album.getAlbumName());
		}
		return SUCCESS;
	}

	public String deletePhoto(){
		photoService.deletePhoto(photoId);
		return SUCCESS;
	}
	
	public void setMyFileContentType(String contentType) {
		System.out.println("文件类型 : " + contentType);
		this.contentType = contentType;
	}

	public void setMyFileFileName(String fileName) {
		System.out.println("文件名称 : " + fileName);
		this.fileName = fileName;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	private static void copy(File src, File dst) {
		try {
			InputStream in = null;
			OutputStream out = null;
			try {
				in = new BufferedInputStream(new FileInputStream(src), BUFFER_SIZE);
				out = new BufferedOutputStream(new FileOutputStream(dst), BUFFER_SIZE);
				byte[] buffer = new byte[BUFFER_SIZE];
				while (in.read(buffer) > 0) {
					out.write(buffer);
				}
			} finally {
				if (null != in) {
					in.close();
				}
				if (null != out) {
					out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PhotoService getPhotoService() {
		return photoService;
	}

	@Resource
	public void setPhotoService(PhotoService photoService) {
		this.photoService = photoService;
	}

	public Map<Integer, String> getAlbumMap() {
		return albumMap;
	}

	public void setAlbumMap(Map<Integer, String> albumMap) {
		this.albumMap = albumMap;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}


}
