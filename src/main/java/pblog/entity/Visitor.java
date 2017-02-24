package pblog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Entity
@Table
public class Visitor {
	private int visitorId;
	private String name;
	private String email;
	private String mac;

	public Visitor() {
	}

	public Visitor(int visitorId, String name, String email, String mac) {
		super();
		this.visitorId = visitorId;
		this.name = name;
		this.email = email;
		this.mac = mac;
	}

	@Id
	@GeneratedValue
	@Column(name = "visitorId")
	public int getVisitorId() {
		return visitorId;
	}

	public void setVisitorId(int visitorId) {
		this.visitorId = visitorId;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "mac")
	public String getmac() {
		return mac;
	}

	public void setmac(String mac) {
		this.mac = mac;
	}

}
