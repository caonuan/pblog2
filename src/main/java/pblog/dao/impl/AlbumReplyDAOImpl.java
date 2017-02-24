package pblog.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import pblog.dao.AlbumReplyDAO;
import pblog.entity.AlbumReply;

@Component("albumReplyDAO")
public class AlbumReplyDAOImpl implements AlbumReplyDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public AlbumReply getByAlbumReplyId(int albumReplyId) {
		AlbumReply albumReply=hibernateTemplate.get(AlbumReply.class, albumReplyId);
		return albumReply;
	}

	@Override
	public List<AlbumReply> getAllAblumReply(int albumId) {
		List<AlbumReply> list=(List<AlbumReply>) hibernateTemplate.find("from pblog.entity.AlbumReply a where a.albumId=?", albumId);
		return list;
	}

	@Override
	public boolean addAlbumReply(AlbumReply albumReply) {
		Serializable s=hibernateTemplate.save(albumReply);
		if(s!=null){
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAlbumReply(int albumReplyId) {
		AlbumReply albumReply=hibernateTemplate.get(AlbumReply.class, albumReplyId);
		hibernateTemplate.delete(albumReply);
		return true;
	}

	@Override
	public boolean deleteAllAlbumReply(int albumId) {
		List<AlbumReply> list=this.getAllAblumReply(albumId);
		hibernateTemplate.deleteAll(list);
		return true;
	}

}
