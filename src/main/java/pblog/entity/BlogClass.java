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
public class BlogClass {
	private int blogClassId;
	private String className;

	public BlogClass() {
	}

	public BlogClass(int blogClassId, String className) {
		super();
		this.blogClassId = blogClassId;
		this.className = className;
	}

	@Id
	@GeneratedValue
	@Column(name = "blogClassId")
	public int getBlogClassId() {
		return blogClassId;
	}

	public void setBlogClassId(int blogClassId) {
		this.blogClassId = blogClassId;
	}

	@Column(name = "classNames")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
