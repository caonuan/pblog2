package pblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pblog.service.ManagerService;
import pblog.util.PropertiesReader;

@Component
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private PropertiesReader propertiesReader;

	@Override
	public String managerLogin(String username, String password) {
		if (propertiesReader.manager_un.equals(username) & propertiesReader.manager_pw.equals(password)) {
			return "success";
		}
		return "error";
	}


	public PropertiesReader getPropertiesReader() {
		return propertiesReader;
	}

	public void setPropertiesReader(PropertiesReader propertiesReader) {
		this.propertiesReader = propertiesReader;
	}
}
