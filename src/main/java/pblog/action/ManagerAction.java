package pblog.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import pblog.service.ManagerService;
@Controller
@Scope("prototype")
public class ManagerAction extends BasicAction implements ServletRequestAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = 855248691978372934L;
	private String username;
	private String password;
	private ManagerService managerService;
	
	private HttpSession session;

	@Override
	public String execute() throws Exception {
		if(session.getAttribute("manager")!=null){
			return "success";
		}
		String iflogin=managerService.managerLogin(username,password);
		if(iflogin.equals("success")){
			session.setAttribute("manager", username);
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

}
