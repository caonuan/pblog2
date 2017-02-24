package pblog.service.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;

import pblog.entity.Visitor;
import pblog.service.ManagerService;
import pblog.util.SingleApplicationContext;

public class ManagerServiceImplTest {
	@Test
	public void loginTest(){
		ApplicationContext ac= SingleApplicationContext.getApplicationContext();
		ManagerService ms=(ManagerService) ac.getBean("managerService");
		HibernateTemplate ht=(HibernateTemplate) ac.getBean("hibernateTemplate");
		Visitor visitor= ht.get(Visitor.class, 3);
		System.out.println(visitor.getName());
		String iflogin=ms.managerLogin("ustb","admin");
		System.out.println(iflogin);
	}
}
