package com.ktc.article.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description 专栏实体类
 * @author admin
 * @date 2020-11-25 12:25:01
 */
@Entity
@Table(name="tb_column")
public class Column implements Serializable{

	@Id
	private String id;//主键ID

	private String name; //专栏名称
	private String summary; //专栏简介
	private String userid; //用户ID
	private java.util.Date createtime; //申请日期
	private java.util.Date checktime; //审核日期
	private String state; //状态

	public String getId() {
		return this.id;
	}

	public void setId(String aValue) {
		this.id = aValue;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSummary() {
		return this.summary;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return this.userid;
	}
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	public void setChecktime(java.util.Date checktime) {
		this.checktime = checktime;
	}

	public java.util.Date getChecktime() {
		return this.checktime;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}

}



