package pblog.action;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import pblog.service.ManagerService;
import pblog.util.Util;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Scope("prototype")
public class ManagerAction extends BasicAction implements ServletRequestAware,ServletResponseAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 855248691978372934L;
	private String username;
	private String password;
	private ManagerService managerService;
	
	private HttpSession session;
	private HttpServletResponse response;

	@Override
	public String execute() throws Exception {
		if(session.getAttribute("manager")!=null){
			return "success";
		}
		String iflogin=managerService.managerLogin(username,password);
		if(iflogin.equals("success")){
			session.setAttribute("manager", username);
			Cookie cookie = Util.makeCookie("manager", username);
			response.addCookie(cookie);
		}
		return iflogin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ManagerService getManagerService() {
		return managerService;
	}
	@Resource
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		session=arg0.getSession();
	}

	@Override
	public void setServletResponse(HttpServletResponse httpServletResponse) {
		response=httpServletResponse;
	}
}
