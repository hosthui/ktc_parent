package com.ktc.recruit.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description 职位实体类
 * @author admin
 * @date 2020-11-24 20:02:07
 */
@Entity
@Table(name="tb_recruit")
public class Recruit implements Serializable{

	@Id
	private String id;//主键ID

	private String jobname; //职位名称
	private String salary; //薪资范围
	private String experience; //经验要求
	private String education; //学历要求
	private String type; //任职方式
	private String address; //办公地址
	private String eid; //企业ID
	private java.util.Date createtime; //创建日期
	private String state; //状态
	private String url; //网址
	private String label; //标签
	private String content1; //职位描述
	private String content2; //职位要求

	public String getId() {
		return this.id;
	}

	public void setId(String aValue) {
		this.id = aValue;
	}
	
	public void setJobname(String jobname) {
		this.jobname = jobname;
	}

	public String getJobname() {
		return this.jobname;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getSalary() {
		return this.salary;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getExperience() {
		return this.experience;
	}
	public void setEducation(String education) {
		this.education = education;
	}

	public String getEducation() {
		return this.education;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getEid() {
		return this.eid;
	}
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public String getContent1() {
		return this.content1;
	}
	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public String getContent2() {
		return this.content2;
	}

}



