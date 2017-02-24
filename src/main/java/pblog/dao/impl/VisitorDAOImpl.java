package pblog.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import pblog.dao.VisitorDAO;
import pblog.entity.AlbumReply;
import pblog.entity.ArticleReply;
import pblog.entity.IPInfo;
import pblog.entity.Visit;
import pblog.entity.Visitor;

@Component("visitorDAO")
public class VisitorDAOImpl implements VisitorDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean addVisitor(Visitor visitor) throws Exception {
		Serializable s = hibernateTemplate.save(visitor);
		if (s != null)
			return true;
		return false;
	}

	@Override
	public Visitor getVisitorById(int id) {
		Visitor visitor = hibernateTemplate.get(Visitor.class, id);
		return visitor;
	}

	@Override
	public Visitor getVisitorByMac(String mac) {
		List<Visitor> visitors =(List<Visitor>) hibernateTemplate.find("from pblog.entity.Visitor v where v.mac=?", mac);
		Visitor visitor =visitors.size()==0?null:visitors.get(0);
		return visitor;
	}

	@Override
	public List<Visitor> getVisitorListByAlbumReply(List<AlbumReply> replyList) {
		List<Visitor> vistorlist = new ArrayList<Visitor>();
		for (AlbumReply albumReply : replyList) {
			int visitorId = albumReply.getVisitorId();
			Visitor visitor = (Visitor) hibernateTemplate
					.find("from pblog.entity.Visitor v where v.visitorId=?", visitorId).get(0);
			vistorlist.add(visitor);
		}
		return vistorlist;
	}

	@Override
	public List<Visitor> getVisitorListByArticleReply(List<ArticleReply> replyList) {
		List<Visitor> vistorlist = new ArrayList<Visitor>();
		for (ArticleReply articleReply : replyList) {
			int visitorId = articleReply.getVisitorId();
			Visitor visitor = (Visitor) hibernateTemplate
					.find("from pblog.entity.Visitor v where v.visitorId=?", visitorId).get(0);
			vistorlist.add(visitor);
		}
		return vistorlist;
	}
	
	@Override
	public boolean saveIPInfo(IPInfo ipInfo) {
		Serializable s = hibernateTemplate.save(ipInfo);
		if (s != null)
			return true;
		return false;
	}
	
	@Override
	public boolean saveVisitInfo(Visit visit) {
		Serializable s = hibernateTemplate.save(visit);
		if (s != null)
			return true;
		return false;
	}
	
	@Override
	public IPInfo getIPInfoByIP(String ip) {
		return hibernateTemplate.get(IPInfo.class, ip);
	}
}
