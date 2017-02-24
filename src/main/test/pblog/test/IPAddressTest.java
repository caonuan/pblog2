package pblog.test;

import java.util.Map;

import org.junit.Test;

import net.sf.json.JSONObject;
import pblog.entity.IPInfo;
import pblog.util.AddressUtils;
import pblog.util.Util;

public class IPAddressTest {

	@Test
	public void IpTest(){
		JSONObject json= AddressUtils.getAddressByIp("10.24.16.153").get(0);
		String country = JSONObject.fromObject(json.get("data")).get("country").toString();  
        String region = JSONObject.fromObject(json.get("data")).get("region").toString();  
        String city = JSONObject.fromObject(json.get("data")).get("city").toString();  
        String county = JSONObject.fromObject(json.get("data")).get("county").toString();  
        String isp = JSONObject.fromObject(json.get("data")).get("isp").toString();  
        String area = JSONObject.fromObject(json.get("data")).get("area").toString();  
        System.out.println("国家： " + country);  
        System.out.println("地区： " + area);  
        System.out.println("省份: " + region);  
        System.out.println("城市： " + city);  
        System.out.println("区/县： " + county);  
        System.out.println("互联网服务提供商： " + isp);
	}
	
	@Test
	public void newIpTest(){
		Map<Integer, JSONObject> jsonObject=AddressUtils.getAddressByIp("61.48.40.26");
		IPInfo ipInfo=Util.getIPInfoByJson(jsonObject);
		System.out.println(ipInfo.getCountry());
	}
}
