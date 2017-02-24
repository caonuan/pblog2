package pblog.service;

import java.util.List;

import pblog.entity.Album;
import pblog.entity.Photo;

public interface PhotoService {
	/**
	 * 在数据库中创建的同时在文件系统下创建以此相册名为名的文件。该相册相片存储在这个文件夹中
	 * @param name
	 * @param url
	 * @return
	 */
	public String createAlbum(String name,String albumUrl);
	
	/**
	 * 将photo存储到以albumName命名的文件夹中，然后将photo信息存储到数据库中
	 * 然后生成缩略图，名字为原图加上前缀s_，存储在原图相同文件夹
	 * @param photo
	 * @return
	 */
	public String addAlbumPhoto(String name,String url,int albumId);
	
	public String updateAlbum(int albumId,String name ,String albumUrl);
	
	/**
	 * 涉及的dao已将评论和photo信息从数据库中删除。这里要做的是删除整个photo的文件夹
	 * @param albumId
	 * @return
	 */
	public String deleteAlbum(int albumId);
	
	/**
	 * 涉及的dao已将photo信息从数据库中删除。这里要做的是删除文件夹中的photo和缩略图。
	 * 缩略图名字为原图加上前缀s_，存储在原图相同文件夹
	 * @param photoId
	 * @return
	 */
	public String deletePhoto(int photoId);
	
	public Album getAlbum(int albumId);
	
	public List<Album> getAllAlbum();
	
	/**
	 * 获取相册的缩略图，缩略图的名字为原图名字加上前缀s_,存储在原图相同的位置
	 * @param albumId
	 * @return 返回所有缩略图的url
	 */
	public List<String> getSmallPhoto(int albumId);
	
	/**
	 * 
	 * @param photoId
	 * @return 返回照片的url
	 */
	public String getPhotoUrlById(int photoId);

	/**
	 * 获取相册的最新的照片
	 * @param albumId
	 * @return
	 */
	public Photo getTopPhotoForAlbum(int albumId);
	
	public List<Photo> getTopFivePhoto();
	
	public List<Photo> getAlbumPhoto(int albumId);
	/**
	 * 获取相册最顶3张照片
	 * @param albumId
	 * @return
	 */
	public List<Photo> getTopThreePhoto(int albumId);
}
