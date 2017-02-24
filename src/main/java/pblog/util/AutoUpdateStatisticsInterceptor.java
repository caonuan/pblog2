package pblog.util;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 这个拦截器作用为每天12点更新Statistics表
 * @author Caonuan
 *
 */
public class AutoUpdateStatisticsInterceptor extends AbstractInterceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2450650081262303279L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
			
		return "success";
	}

}
