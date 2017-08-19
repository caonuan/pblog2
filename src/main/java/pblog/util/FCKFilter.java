package pblog.util;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FCKFilter extends StrutsPrepareAndExecuteFilter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		String URI = request.getRequestURI();
		String[] uriArray = URI.split("/ckfinder/core/connector/java/*/");
		int arrayLen = uriArray.length;
		if (arrayLen >= 2) {
			chain.doFilter(req, res);
		} else {
			super.doFilter(req, res, chain);
		}
	}
}