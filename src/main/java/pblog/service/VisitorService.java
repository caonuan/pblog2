package pblog.service;

import pblog.entity.*;

import java.util.List;

public interface VisitorService {
	/**
	 * 注册
	 * 
	 * @param name
	 * @param email
	 * @param mac
	 * @return
	 */
	public String visitorRegister(String name, String email, String mac);

	/**
	 * 匹配mac地址，获得visitor实例
	 * 
	 * @param mac
	 * @return
	 */
	public Visitor getVisitor(String mac);
	

	public List<Visitor> getVisitorListByArticleReply(List<ArticleReply> replyList);

	public List<Visitor> getVisitorListByAlbumReply(List<AlbumReply> replyList);
	
	public Visitor getVisitorById(int visitorId);
	
	public boolean saveVisitInfo(Visit visit);
	
	public boolean saveIPInfoByJson(IPInfo ipInfo);

	public IPInfo getIPInfoByIP(String ip);
}
