package pblog.dao;

import java.util.List;

import pblog.entity.Photo;

public interface PhotoDAO {
	public boolean addPhoto(Photo photo);
	
	
	public boolean deletePhotoById(int photoId);
	
	/**
	 * 通过关键字检索图片。
	 * @param keyWord
	 * @return
	 */
	public List<Photo> getPhotoByKeyWord(String keyWord);
	
	public Photo getPhotoById(int photoId);
	
	public List<Photo> getPhotoByPage(int page);
}
