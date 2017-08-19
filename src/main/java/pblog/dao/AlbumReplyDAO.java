package pblog.dao;

import pblog.entity.AlbumReply;

import java.util.List;

public interface AlbumReplyDAO {
	/**
	 * 通过相册评论id寻找评论
	 *
	 * @param albumReplyId 相册评论id
	 * @return 相册评论
	 */
	public AlbumReply getByAlbumReplyId(int albumReplyId);

	/**
	 * 通过相册id寻找所有此相册的评论
	 *
	 * @param albumId 相册id
	 * @return
	 */
	public List<AlbumReply> getAllAblumReply(int albumId);

	/**
	 * 添加相册评论
	 *
	 * @param albumReply
	 * @return
	 */
	public boolean addAlbumReply(AlbumReply albumReply);

	/**
	 * 通过评论id删除评论。管理员调用。
	 *
	 * @param albumReply
	 * @return 是否成功
	 */
	public boolean deleteAlbumReply(int albumReplyId);

	/**
	 * 删除某相册的所有评论，可调用getAllAblumReply方法。
	 *
	 * @param albumId 相册id
	 * @return 是否成功
	 */
	public boolean deleteAllAlbumReply(int albumId);
}
