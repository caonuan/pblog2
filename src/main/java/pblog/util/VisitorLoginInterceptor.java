package pblog.util;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import net.sf.json.JSONObject;
import pblog.entity.IPInfo;
import pblog.entity.Visit;
import pblog.entity.Visitor;
import pblog.service.VisitorService;

public class VisitorLoginInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1091066150334661975L;

	@Autowired
	private VisitorService visitorService;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		ActionContext actionContext = arg0.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(StrutsStatics.HTTP_REQUEST);
		Map<String, Object> session = arg0.getInvocationContext().getSession();
		Visitor visitor = (Visitor) session.get("visitor");
		String ip = (String) session.get("ip");
		if (ip == null) {
			ip = getIpAddr(request);
			session.put("ip", ip);
			loginByIP(ip, session);
		}
		// 判断表中是否有ip信息，没有则查询并保存
		// 17-2-24发现即使判断出表中有ip信息也可能进入存储ip信息的代码段，所以加了个try-catch
		IPInfo ipInfo = visitorService.getIPInfoByIP(ip);
		if (ipInfo == null) {
			Map<Integer, JSONObject> map = AddressUtils.getAddressByIp(ip);
			ipInfo = Util.getIPInfoByJson(map);
			try {
				visitorService.saveIPInfoByJson(ipInfo);
			} catch (Exception e) {
				;
			}
		}

		// 保存访问信息
		Visit visit = new Visit(new Date(), Util.getRequstUrl(request),
				AddressUtils.getPositionByIPInfo(ipInfo), ipInfo);
		if (!ip.equals("127.0.0.1")) {
			visitorService.saveVisitInfo(visit);
		}
		if (visitor != null) {
			return arg0.invoke();
		} else {
			return arg0.invoke();
		}
	}

	public void loginByIP(String ip, Map<String, Object> session) {
		Visitor visitor = visitorService.getVisitor(ip);
		if (visitor != null) {
			session.put("visitor", visitor);
		}
	}

	public String getIpAddr(HttpServletRequest request) throws Exception {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
