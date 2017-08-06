package pblog.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import pblog.entity.Visitor;
import pblog.service.ReplyService;
import pblog.service.VisitorService;

@Controller
@Scope("prototype")
public class AddArticleReplyAction extends BasicAction implements ServletRequestAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6560548719090950439L;
	private int articleId;
	private String name;
	private String email;
	private String content;
	private VisitorService visitorService;
	private ReplyService replyService;
	private HttpSession session;

	@Override
	public String execute() throws Exception {
		Visitor visitor=(Visitor) session.getAttribute("visitor");
		String ip=(String) session.getAttribute("ip");
		if(name==null||name.equals("")||email==null||email.equals("")||ip==null||ip.equals("")){
			return super.execute();
		}
		if(visitor==null){
			visitorService.visitorRegister(name, email, ip);
			visitor=visitorService.getVisitor(ip);
			session.setAttribute("visitor", visitor);
		}
		replyService.addArticleReply(content, visitor.getVisitorId(),0, articleId);
		return super.execute();
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public VisitorService getVisitorService() {
		return visitorService;
	}

	@Resource
	public void setVisitorService(VisitorService visitorService) {
		this.visitorService = visitorService;
	}

	public ReplyService getReplyService() {
		return replyService;
	}

	@Resource
	public void setReplyService(ReplyService replyService) {
		this.replyService = replyService;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		session = arg0.getSession();
	}

}
