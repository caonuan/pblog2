package pblog.service;

public interface ManagerService {
	/**
	 * ��¼�ɹ�����session�ﱣ���¼��Ϣ
	 * username��password��information.properties�����ļ���.
	 * @param username
	 * @param password
	 * @return
	 */
	public String managerLogin(String username,String password);
	
	
}
