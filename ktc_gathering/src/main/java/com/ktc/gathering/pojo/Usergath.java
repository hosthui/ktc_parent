package com.ktc.gathering.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description 用户关注活动实体类
 * @author admin
 * @date 2020-11-25 14:01:41
 */
@Entity
@Table(name="tb_usergath")
public class Usergath implements Serializable{

	@Id
	private String userid;//主键ID

	private java.util.Date exetime; //点击时间

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String aValue) {
		this.userid = aValue;
	}
	
	public void setExetime(java.util.Date exetime) {
		this.exetime = exetime;
	}

	public java.util.Date getExetime() {
		return this.exetime;
	}

}



