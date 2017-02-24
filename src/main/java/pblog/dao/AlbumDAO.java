package pblog.dao;

import java.util.List;

import pblog.entity.Album;
import pblog.entity.Photo;

public interface AlbumDAO {

	public List<Album> getAllAblum();

	/*
	 * 暂时不需要实现
	 */
	public List<Photo> getPhotoByPage(int albumId, int page);

	/**
	 * 通过相册id获取所有相片
	 * 
	 * @param albumId
	 * @return
	 */
	public List<Photo> getAllPhoto(int albumId);

	/**
	 * 
	 * @param album
	 *            加入数据库的相册
	 * @return 是否成功，ture为成功，false为失败
	 */
	public boolean createAlbum(Album album);

	/**
	 * 通过相册id查询相册
	 * 
	 * @param id
	 * @return
	 */
	public Album getAlbumById(int albumId);

	/**
	 * 修改一个相册的名称或者封面
	 * 
	 * @param album
	 * @return 是否修改成功
	 */
	public boolean updateAlbum(Album album);

	/**
	 * 删除相册。同时把相册内的所有照片、评论从数据库中删除。
	 * 
	 * @param albumId
	 * @return
	 */
	public boolean deleteAlbum(int albumId);

	/**
	 * 获得这个相册最新的图片
	 * @return
	 */
	public Photo getTopPhoto(int albumId);
	
	/**
	 * 获得这个相册最新的3张图片
	 * @param albumId
	 * @return
	 */
	public List<Photo> getTopThreePhoto(int albumId);
}
