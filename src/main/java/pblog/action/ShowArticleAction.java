package pblog.action;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pblog.entity.Article;
import pblog.entity.ArticleReply;
import pblog.entity.BlogClass;
import pblog.entity.Visitor;
import pblog.service.ArticleService;
import pblog.service.ReplyService;
import pblog.service.VisitorService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 查看具体文章的action
 * 
 * @author Caonuan
 *
 */
@Controller
@Scope("prototype")
public class ShowArticleAction extends BasicAction implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5533346504612961386L;
	private int articleId;
	private Article article;
	private List<ArticleReply> replyList;
	private List<Visitor> visitorList;
	private ArticleService articleService;
	private ReplyService replyService;
	private VisitorService visitorService;
	private List<BlogClass> blogClassList;
	private BlogClass blogClass;
	private Visitor visitor;
	private HttpSession session;
	private List<Object[]> timeList;

	@Override
	public String execute() throws Exception {
		article = articleService.getOneArticle(articleId);
		if (article != null) {
			replyList = replyService.getArticleReplys(articleId);
			visitorList = visitorService.getVisitorListByArticleReply(replyList);
			blogClass = articleService.getBlogClassById(article.getBlogClassId());
		}
		if(article.getHidden()==1&&session.getAttribute("manager")==null)
			return "error";
		blogClassList = articleService.getAllBlogClass();
		timeList = articleService.getAllMonthsWhichHaveArticle();
		visitor = (Visitor) session.getAttribute("visitor");
		String content = article.getContent();
		// 对所有的<img>标签进行处理，将路径变为绝对路径，加上style=max-width:100% 属性
		int searchIndex = 0;
		do {
			searchIndex = content.indexOf("<img", searchIndex);
			if (searchIndex != -1)
				content = content.substring(0, searchIndex + 4)
						+ " style=\"max-width:100%;\""
						+ content.substring(searchIndex + 4, content.length());
			searchIndex += 1;
		} while (searchIndex != 0);
		// 对所有的<a>标签进行处理，加上target="_blank"属性
		searchIndex=0;
		do {
			searchIndex = content.indexOf("<a", searchIndex);
			if (searchIndex != -1)
				content = content.substring(0, searchIndex + 2)
						+ " target=\"_blank\""
						+ content.substring(searchIndex + 2, content.length());
			searchIndex += 1;
		} while (searchIndex != 0);
		content=content.replaceAll("pblog/userfiles",getImage_server()+"/pblog/userfiles");
		article.setContent(content);
		/*
		 * if(visitor==null){ return "visitorNotExist"; }
		 */
		return super.execute();
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	@Resource
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public ReplyService getReplyService() {
		return replyService;
	}

	@Resource
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	public List<ArticleReply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ArticleReply> replyList) {
		this.replyList = replyList;
	}

	public List<Visitor> getVisitorList() {
		return visitorList;
	}

	public void setVisitorList(List<Visitor> visitorList) {
		this.visitorList = visitorList;
	}

	public VisitorService getVisitorService() {
		return visitorService;
	}

	@Resource
	public void setVisitorService(VisitorService visitorService) {
		this.visitorService = visitorService;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public List<BlogClass> getBlogClassList() {
		return blogClassList;
	}

	public void setBlogClassList(List<BlogClass> blogClassList) {
		this.blogClassList = blogClassList;
	}

	public BlogClass getBlogClass() {
		return blogClass;
	}

	public void setBlogClass(BlogClass blogClass) {
		this.blogClass = blogClass;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		session = request.getSession();
	}

	public List<Object[]> getTimeList() {
		return timeList;
	}

	public void setTimeList(List<Object[]> timeList) {
		this.timeList = timeList;
	}

}
