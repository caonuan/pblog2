package pblog.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pblog.dao.VisitorDAO;
import pblog.entity.Visitor;

public class VisitorDAOTest {

	private ApplicationContext context = null;
	private VisitorDAO vdao = null;

	{
		context = new ClassPathXmlApplicationContext("beans.xml");
		vdao = (VisitorDAO) context.getBean("visitorDAO");

	}

	@Test
	public void testAddVisitor() throws Exception {
		Visitor visitor = new Visitor();
		visitor.setName("曹怒安");
		visitor.setEmail("caonuan@hotmail.com");
		visitor.setmac("E0-DB-55-B0-1A-DC");
		boolean b=vdao.addVisitor(visitor);
		System.out.println(b);
	}
	
	@Test
	public void getVisitorByMacTest(){
		Visitor visitor;
		visitor=vdao.getVisitorByMac("E0-DB-55-B0-1A-DC");
		System.out.println(visitor.getName());
	}
	
	@Test
	public void getVisitorByIdTest(){
		Visitor visitor;
		visitor=vdao.getVisitorById(3);
		System.out.println(visitor.getName());
	}

}
