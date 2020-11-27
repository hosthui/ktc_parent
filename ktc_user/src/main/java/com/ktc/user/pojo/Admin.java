package com.ktc.user.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description 管理员实体类
 * @author admin
 * @date 2020-11-27 16:52:19
 */
@Entity
@Table(name="tb_admin")
public class Admin implements Serializable{

	@Id
	private String id;//主键ID

	private String loginname; //登陆名称
	private String password; //密码
	private String state; //状态

	public String getId() {
		return this.id;
	}

	public void setId(String aValue) {
		this.id = aValue;
	}
	
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getLoginname() {
		return this.loginname;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}

}



