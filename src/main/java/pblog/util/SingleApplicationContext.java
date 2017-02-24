package pblog.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingleApplicationContext {
	private volatile static ApplicationContext ac;
	
	public static ApplicationContext getApplicationContext(){
		if(ac==null){
			synchronized (ApplicationContext.class) {
				ac=new ClassPathXmlApplicationContext("beans.xml");
			}
		}
		return ac;
	}
	
	
}
