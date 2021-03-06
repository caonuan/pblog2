package pblog.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.StrutsStatics;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ManagerLoginInterceptor extends AbstractInterceptor{

	/**
	 *
	 */
	private static final long serialVersionUID = -7452866050565173107L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
        ActionContext actionContext = arg0.getInvocationContext();
        HttpServletRequest request= (HttpServletRequest) actionContext.get(StrutsStatics.HTTP_REQUEST);
        Map<String, Object> session = actionContext.getSession();
		String manager = (String) session.get("manager");
		Cookie[] cookies=request.getCookies();
        if (manager == null)
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("manager".equals(cookie.getName())) {
                        manager = cookie.getValue();
                        break;
                    }
                }
            }
        PropertiesReader ps = (PropertiesReader) SingleApplicationContext.getApplicationContext().getBean("propertiesReader");
		String unm = ps.manager_un;
		if (manager!=null&&manager.equals(unm)) {
            session.put("manager", unm);
			return arg0.invoke();
		} else {
			return "login";
		}
	}

}
