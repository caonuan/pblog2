package pblog.dao;

import pblog.entity.*;

import java.util.List;

public interface VisitorDAO {
	public boolean addVisitor(Visitor visitor) throws Exception;

	public Visitor getVisitorById(int id);

	/**
	 * 通过mac地址获取
	 * 
	 * @param mac
	 * @return
	 */
	public Visitor getVisitorByMac(String mac);

	/**
	 * 跟据回复id获取回复评论
	 * @param replyList
	 * @return
	 */
	public List<Visitor> getVisitorListByArticleReply(List<ArticleReply> replyList);
	public List<Visitor> getVisitorListByAlbumReply(List<AlbumReply> replyList);
	
	public boolean saveVisitInfo(Visit visit);
	
	public IPInfo getIPInfoByIP(String ip);
	
	public boolean saveIPInfo(IPInfo ipInfo);
}
