package pblog.util;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    private HttpServletRequest request;
    private HttpServletResponse response;
    private Map<String, Object> session;
    private int cookie_visitor_id;
    private Visitor visitor;
    private IPInfo ipInfo;
    private String ip;

    @Override
    public String intercept(ActionInvocation arg0) throws Exception {
        ActionContext actionContext = arg0.getInvocationContext();
        request = (HttpServletRequest) actionContext
                .get(StrutsStatics.HTTP_REQUEST);
        response = (HttpServletResponse) actionContext.get(StrutsStatics.HTTP_RESPONSE);
        session = actionContext.getSession();

        visitor = (Visitor) session.get("visitor");
        ip = (String) session.get("ip");
        if (ip == null) {
            ip = getIpAddr(request);
            session.put("ip", ip);
        }
        // session中找不到visitor时
        if (visitor == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null)
                for (Cookie cookie : cookies) {
                    if ("visitor_id".equals(cookie.getName())) {
                        cookie_visitor_id = Integer.valueOf(cookie.getValue());
                        break;
                    }
                }
            if (cookie_visitor_id != 0) {
                visitor = visitorService.getVisitorById(cookie_visitor_id);
                session.put("visitor", visitor);
                // cookie获取visitor成功时更新cookie
                response.addCookie(Util.makeCookie("visitor_id", String.valueOf(visitor.getVisitorId())));
            } else {
                //cookie中找不到visitor时通过ip找
                visitor = visitorService.getVisitor(ip);
                if (visitor != null) {
                    response.addCookie(Util.makeCookie("visitor_id", String.valueOf(visitor.getVisitorId())));
                    session.put("visitor", visitor);
                }
            }
        } else {
            // session获取visitor成功时更新cookie
            response.addCookie(Util.makeCookie("visitor_id", String.valueOf(visitor.getVisitorId())));
        }
        // 保存访问信息
        // 判断表中是否有ip信息，没有则查询并保存
        // 17-2-24发现即使判断出表中有ip信息也可能进入存储ip信息的代码段，所以加了个try-catch
        ipInfo = visitorService.getIPInfoByIP(ip);
        if (ipInfo == null) {
            Map<Integer, JSONObject> map = AddressUtils.getAddressByIp(ip);
            ipInfo = Util.getIPInfoByJson(map);
            try {
                visitorService.saveIPInfoByJson(ipInfo);
            } catch (Exception e) {
                ;
            }
        }
        Visit visit = new Visit(new Date(), Util.getRequstUrl(request),
                AddressUtils.getPositionByIPInfo(ipInfo), ipInfo);
        if (!ipInfo.getIp().equals("127.0.0.1")) {
            visitorService.saveVisitInfo(visit);
        } else if (visitor == null) {
            // 本地自动登录自己
            response.addCookie(Util.makeCookie("visitor_id", "1"));
            visitor = visitorService.getVisitorById(1);
            session.put("visitor", visitor);
        }
        if (visitor != null) {
            return arg0.invoke();
        } else {
            return arg0.invoke();
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
