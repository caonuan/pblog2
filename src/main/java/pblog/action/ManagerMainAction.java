package pblog.action;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Scope("prototype")
public class ManagerMainAction extends BasicAction implements ServletRequestAware {
	private HttpSession session;

	@Override
	public String execute() throws Exception {
		String manager = (String) session.getAttribute("manager");
		if (manager!=null)
			return "already";
		else
			return "login";
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		session = arg0.getSession();
	}
}
