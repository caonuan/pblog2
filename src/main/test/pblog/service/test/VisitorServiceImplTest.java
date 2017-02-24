package pblog.service.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.sf.json.JSONObject;
import pblog.service.VisitorService;
import pblog.util.AddressUtils;
import pblog.util.Util;

public class VisitorServiceImplTest {
	private ApplicationContext context = null;
	private VisitorService VS = null;

	{
		context = new ClassPathXmlApplicationContext("beans.xml");
		VS = (VisitorService) context.getBean("visitorService");
	}

	@Test
	public void visitorRegisterTest() {
		String flag = VS.visitorRegister("aaac", "51515616@qq.com",
				"E0-DB-55-B0-1A-DC");
		if (flag == "success") {
			System.out.println("success");
		} else {
			System.out.println("error");
		}
	}
	
	@Test
	//这个测试方法有错误
	public void ipInfoTest(){
		JSONObject jsonObject= AddressUtils.getAddressByIp("121.42.40.136").get(0);
		System.out.println(jsonObject);
		VS.saveIPInfoByJson(Util.getIPInfoByJson(jsonObject));
	}

}
