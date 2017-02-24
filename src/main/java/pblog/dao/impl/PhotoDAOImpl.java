package pblog.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import pblog.dao.PhotoDAO;
import pblog.entity.Photo;
@Component("photoDAO")
public class PhotoDAOImpl implements PhotoDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean addPhoto(Photo photo) {
		hibernateTemplate.save(photo);
		return true;
	}

	@Override
	public boolean deletePhotoById(int photoId) {
		Photo photo=hibernateTemplate.get(Photo.class,photoId);
		hibernateTemplate.delete(photo);
		return true;
	}

	@Override
	public List<Photo> getPhotoByKeyWord(String keyWord) {
		return null;
	}
	
	@Override
	public Photo getPhotoById(int photoId){
		Photo photo=hibernateTemplate.get(Photo.class, photoId);
		return photo;
	}
	
	@Override
	public List<Photo> getPhotoByPage(final int page){
		@SuppressWarnings("unchecked")
		List<Photo> list = (List<Photo>) hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException {
				Query query = session.createQuery("from Photo order by publishDate desc");
				query.setMaxResults(5);
				query.setFirstResult((page - 1) * 5);
				return query.list();
			}
		});
		return list;
		
	}
}
