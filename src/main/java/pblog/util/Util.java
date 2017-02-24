package pblog.util;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;
import pblog.entity.IPInfo;

public class Util {
	/**
	 * 不着急实现
	 */
	public static void makeSmallPhoto() {

	}

	// 获取当前路径
	public static void getPath() {
		File f = new File("");
		try {
			System.out.println(f.getCanonicalPath());// 获取标准的路径
			System.out.println(f.getAbsolutePath());// 获取绝对路径
		} catch (Exception e) {
		}
	}

	public static boolean deleteFileBySrc(String src) {
		File file = new File(src); // 输入要删除的文件位置
		if (file.exists())
			file.delete();
		return file.exists() ? false : true;
	}

	public static boolean createFileBySrc(String src) throws IOException {
		File file = new File(src);
		if (!file.exists())
			file.mkdirs();
		return file.exists() ? true : false;
	}

	public static IPInfo getIPInfoByJson(Map<Integer,JSONObject> map) {
		int index = (int) map.keySet().toArray()[0];
		JSONObject jsonObject = map.get(index);
		if (index == 0) {
			if (jsonObject != null) {
				String country = JSONObject.fromObject(jsonObject.get("data"))
						.get("country").toString();
				String region = JSONObject.fromObject(jsonObject.get("data"))
						.get("region").toString();
				String city = JSONObject.fromObject(jsonObject.get("data"))
						.get("city").toString();
				String county = JSONObject.fromObject(jsonObject.get("data"))
						.get("county").toString();
				String isp = JSONObject.fromObject(jsonObject.get("data")).get("isp")
						.toString();
				String area = JSONObject.fromObject(jsonObject.get("data"))
						.get("area").toString();
				String country_id = JSONObject.fromObject(jsonObject.get("data"))
						.get("country_id").toString();
				String region_id = JSONObject.fromObject(jsonObject.get("data"))
						.get("region_id").toString();
				String city_id = JSONObject.fromObject(jsonObject.get("data"))
						.get("city_id").toString();
				String county_id = JSONObject.fromObject(jsonObject.get("data"))
						.get("county_id").toString();
				String isp_id = JSONObject.fromObject(jsonObject.get("data"))
						.get("isp_id").toString();
				String area_id = JSONObject.fromObject(jsonObject.get("data"))
						.get("area_id").toString();
				String ip = JSONObject.fromObject(jsonObject.get("data"))
						.getString("ip").toString();
				IPInfo ipInfo = new IPInfo(ip, country, country_id, area, area_id,
						region, region_id, city, city_id, county, county_id, isp,
						isp_id);
				return ipInfo;
			} else {
				return null;
			}
		}else if(index==1){
			if (jsonObject != null) {
				String country=jsonObject.getString("country").toString();
				String region=jsonObject.getString("province").toString();
				String city=jsonObject.getString("city").toString();
				String county=jsonObject.getString("district").toString();
				String isp=jsonObject.getString("isp").toString();
				String ip=jsonObject.getString("ip").toString();
				IPInfo ipInfo=new IPInfo(ip, country, null, null, null, region, null, city, null, county, null, isp, null);
				return ipInfo;
			} else {
				return null;
			}
		}
		return null;
	}

	public static String getRequstUrl(HttpServletRequest request) {
		// java 获取请求 URL
		String url = request.getScheme() + "://"; // 请求协议 http 或 https
		url += request.getHeader("host"); // 请求服务器
		url += request.getRequestURI(); // 工程名
		if (request.getQueryString() != null) // 判断请求参数是否为空
			url += "?" + request.getQueryString(); // 参数
		return url;
	}
}
