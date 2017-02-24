package pblog.service.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import pblog.service.ManagerService;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
	// action配置文件路径
	public static final String ACTIONPATH = "/WEB-INF/classes/information.properties";
	{
		// System.out.println(ManagerServiceImpl.class.getClassLoader().getResource(""));
	}
	// 属性文件
	public static final Properties prop = new Properties();

	@Override
	public String managerLogin(String username, String password) {
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
		String pwd = prop.getProperty("password");
		if(unm==null&&pwd==null){
			unm="caonuan";
			pwd="shltalent";
		}
		//System.out.println(unm + "" + pwd);
		if (unm.equals(username) & pwd.equals(password)) {
			return "success";
		}
		return "error";
	}

}
