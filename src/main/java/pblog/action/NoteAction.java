package pblog.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import pblog.entity.Visitor;
import pblog.service.NoteService;
import pblog.service.VisitorService;
@Controller
@Scope("prototype")
public class NoteAction extends ActionSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8218934505459563277L;

	private String mac;
	private int visitorId;
	private String name;
	private String email;
	private String content;
	private NoteService noteService;
	private VisitorService visitorService;
	private HttpSession session;

	public String addNote() {
		Visitor visitor = (Visitor) session.getAttribute("visitor");
		if (visitor == null) {
			String ip = (String) session.getAttribute("ip");
			visitorService.visitorRegister(name, email, ip);
			visitor = visitorService.getVisitor(ip);
			session.setAttribute("visitor", visitor);
		}
		noteService.addNote(content, visitor.getVisitorId(), 1);
		return SUCCESS;
	}

	public NoteService getNoteService() {
		return noteService;
	}

	@Resource
	public void setNoteService(NoteService noteService) {
		this.noteService = noteService;
	}

	public VisitorService getVisitorService() {
		return visitorService;
	}

	@Resource
	public void setVisitorService(VisitorService visitorService) {
		this.visitorService = visitorService;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
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

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		session = request.getSession();
	}
}
