package pblog.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Component
@Scope("prototype")
@Entity
@Table
public class Visit {
	private int visitId;
	private Date time;
	private String url;
	private String position;
	private IPInfo ipInfo;

	public Visit() {
		super();
	}

	public Visit(Date time, String url, String position, IPInfo ipInfo) {
		super();
		this.time = time;
		this.url = url;
		this.position = position;
		this.ipInfo = ipInfo;
	}

	@Id
	@GeneratedValue
	public int getVisitId() {
		return visitId;
	}

	public void setVisitId(int visitId) {
		this.visitId = visitId;
	}

	@Column(name = "time")
	@Temporal(value = TemporalType.TIMESTAMP)
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "url")
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Column(name = "position")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ip", nullable = false)
	public IPInfo getIpInfo() {
		return ipInfo;
	}

	public void setIpInfo(IPInfo ipInfo) {
		this.ipInfo = ipInfo;
	}

}
