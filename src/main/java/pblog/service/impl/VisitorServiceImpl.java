package pblog.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import pblog.dao.VisitorDAO;
import pblog.entity.AlbumReply;
import pblog.entity.ArticleReply;
import pblog.entity.IPInfo;
import pblog.entity.Visit;
import pblog.entity.Visitor;
import pblog.service.VisitorService;

@Service("visitorService")
public class VisitorServiceImpl implements VisitorService {

	private VisitorDAO visitorDAO;

	public VisitorDAO getVisitorDAO() {
		return visitorDAO;
	}

	@Resource
	public void setVisitorDAO(VisitorDAO visitorDAO) {
		this.visitorDAO = visitorDAO;
	}

	// 在页面是先根据mac地址获取visitor，如果visitor为空，则进行注册。
	@Override
	public String visitorRegister(String name, String email, String mac) {
		Visitor visitor = new Visitor();
		visitor.setName(name);
		visitor.setEmail(email);
		visitor.setmac(mac);
		try {
			if (visitorDAO.addVisitor(visitor) == true) {
				return "success";
			}
			return "save_error";
		} catch (Exception e) {
			e.printStackTrace();
			return "sql_error";
		}
	}

	@Override
	// 在页面是先根据mac地址获取visitor，如果visitor不为空
	public Visitor getVisitor(String mac) {
		Visitor visitor = visitorDAO.getVisitorByMac(mac);
		return visitor;
	}

	@Override
	public List<Visitor> getVisitorListByAlbumReply(List<AlbumReply> replyList) {
		List<Visitor> visitorList = visitorDAO.getVisitorListByAlbumReply(replyList);
		return visitorList;
	}

	@Override
	public List<Visitor> getVisitorListByArticleReply(List<ArticleReply> replyList) {
		List<Visitor> visitorList = visitorDAO
				.getVisitorListByArticleReply(replyList);
		return visitorList;
	}

	@Override
	public Visitor getVisitorById(int visitorId) {
		return visitorDAO.getVisitorById(visitorId);
	}

	@Override
	public boolean saveIPInfoByJson(IPInfo ipInfo) {
	
		return visitorDAO.saveIPInfo(ipInfo);
	}

	@Override
	public IPInfo getIPInfoByIP(String ip){
		IPInfo ipInfo= visitorDAO.getIPInfoByIP(ip);
		return ipInfo;
	}
	
	@Override
	public boolean saveVisitInfo(Visit visit) {
		return visitorDAO.saveVisitInfo(visit);
	}
}
