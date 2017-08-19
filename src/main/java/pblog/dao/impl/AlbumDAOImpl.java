package pblog.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;
import pblog.dao.AlbumDAO;
import pblog.entity.Album;
import pblog.entity.AlbumReply;
import pblog.entity.Photo;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@Component("albumDAO")
public class AlbumDAOImpl implements AlbumDAO {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public List<Album> getAllAblum() {
		List<Album> list = (List<Album>) hibernateTemplate
				.find("from pblog.entity.Album");
		return list;
	}

	@Override
	public List<Photo> getPhotoByPage(int albumId, final int page) {
		@SuppressWarnings("unchecked")
		List<Photo> list = (List<Photo>) hibernateTemplate
				.execute(new HibernateCallback<Object>() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException {
						Query query = session.createQuery("from Photo");
						// 设置每页显示多少个，设置多大结果。
						query.setMaxResults(10);
						// 设置起点
						query.setFirstResult((page - 1) * 10);
						return query.list();
					}
				});
		return list;
	}

	@Override
	public List<Photo> getAllPhoto(int albumId) {
		List<Photo> list = (List<Photo>) hibernateTemplate
				.find("from pblog.entity.Photo p where p.albumId=?", albumId);
		return list;
	}

	@Override
	public boolean createAlbum(Album album) {
		Serializable s = hibernateTemplate.save(album);
		if (s != null) {
			return true;
		}
		return false;
	}

	@Override
	public Album getAlbumById(int albumId) {
		Album album = hibernateTemplate.get(Album.class, albumId);
		return album;
	}

	@Override
	public boolean updateAlbum(Album album) {
		hibernateTemplate.update(album);
		return true;
	}

	@Override
	public boolean deleteAlbum(int albumId) {
		List<Photo> photoList = (List<Photo>) hibernateTemplate
				.find("from Photo where albumId=?", albumId);
		hibernateTemplate.deleteAll(photoList);
		List<AlbumReply> albumReplyList = (List<AlbumReply>) hibernateTemplate
				.find("from AlbumReply where albumId=?", albumId);
		hibernateTemplate.deleteAll(albumReplyList);
		Album album = this.getAlbumById(albumId);
		hibernateTemplate.delete(album);
		if (album != null)
			return true;
		return false;
	}

	@Override
	public Photo getTopPhoto(int albumId) {
		List<Photo> photos = (List<Photo>) hibernateTemplate.find(
				"from Photo p where p.albumId=? order by p.publishDate desc",
				albumId);
		if (photos.size() != 0)
			return photos.get(0);
		return null;
	}

	@Override
	public List<Photo> getTopThreePhoto(int albumId) {
		List<Photo> photos = (List<Photo>) hibernateTemplate.find(
				"from Photo p where p.albumId=? order by p.publishDate desc",
				albumId);
		if (photos.size() >= 3)
			return photos.subList(0, 3);
		else if(photos.size()>0){
			return photos.subList(0, photos.size());
		}
		return null;
	}
}
