package pblog.dao;

import java.util.List;

import pblog.entity.AlbumReply;
import pblog.entity.ArticleReply;
import pblog.entity.IPInfo;
import pblog.entity.Visit;
import pblog.entity.Visitor;

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
