package pblog.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ManagerLoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7452866050565173107L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Map<String, Object> session = arg0.getInvocationContext().getSession();
		String manager = (String) session.get("manager");
		Properties prop = new Properties();
		String ACTIONPATH = "/WEB-INF/classes/information.properties";
		FileInputStream fis;
		String path = null;
		try {
			path =ServletActionContext.getServletContext().getRealPath("/");
		} catch (Exception e) {
		}
		try {
			fis = new FileInputStream(path + ACTIONPATH);
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String unm = prop.getProperty("username");
		if (manager!=null&&manager.equals(unm)) {
			return arg0.invoke();
		} else {
			return "login";
		}
	}

}
