package pblog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table
public class IPInfo {
	private String ip;
	private String country;
	private String country_id;
	private String area;
	private String area_id;
	private String region;
	private String region_id;
	private String city;
	private String city_id;
	private String county;
	private String county_id;
	private String isp;
	private String isp_id;

	public IPInfo() {
		super();
	}

	public IPInfo(String ip, String country, String country_id, String area,
			String area_id, String region, String region_id, String city,
			String city_id, String county, String county_id, String isp,
			String isp_id) {
		super();
		this.ip = ip;
		this.country = country;
		this.country_id = country_id;
		this.area = area;
		this.area_id = area_id;
		this.region = region;
		this.region_id = region_id;
		this.city = city;
		this.city_id = city_id;
		this.county = county;
		this.county_id = county_id;
		this.isp = isp;
		this.isp_id = isp_id;
	}

	@Id
	@Column(name = "ip")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "country_id")
	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	@Column(name = "area")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "area_id")
	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}

	@Column(name = "region")
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Column(name = "region_id")
	public String getRegion_id() {
		return region_id;
	}

	public void setRegion_id(String region_id) {
		this.region_id = region_id;
	}

	@Column(name = "city")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "city_id")
	public String getCity_id() {
		return city_id;
	}

	public void setCity_id(String city_id) {
		this.city_id = city_id;
	}

	@Column(name = "county")
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Column(name = "county_id")
	public String getCounty_id() {
		return county_id;
	}

	public void setCounty_id(String county_id) {
		this.county_id = county_id;
	}

	@Column(name = "isp")
	public String getIsp() {
		return isp;
	}

	public void setIsp(String isp) {
		this.isp = isp;
	}

	@Column(name = "isp_id")
	public String getIsp_id() {
		return isp_id;
	}

	public void setIsp_id(String isp_id) {
		this.isp_id = isp_id;
	}

}
