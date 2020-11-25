package com.ktc.gathering.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description 活动实体类
 * @author admin
 * @date 2020-11-25 14:01:12
 */
@Entity
@Table(name="tb_gathering")
public class Gathering implements Serializable{

	@Id
	private String id;//主键ID

	private String name; //活动名称
	private String summary; //大会简介
	private String detail; //详细说明
	private String sponsor; //主办方
	private String image; //活动图片
	private java.util.Date starttime; //开始时间
	private java.util.Date endtime; //截止时间
	private String address; //举办地点
	private java.util.Date enrolltime; //报名截止
	private String state; //是否可见
	private String city; //城市

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
	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDetail() {
		return this.detail;
	}
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}

	public String getSponsor() {
		return this.sponsor;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return this.image;
	}
	public void setStarttime(java.util.Date starttime) {
		this.starttime = starttime;
	}

	public java.util.Date getStarttime() {
		return this.starttime;
	}
	public void setEndtime(java.util.Date endtime) {
		this.endtime = endtime;
	}

	public java.util.Date getEndtime() {
		return this.endtime;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}
	public void setEnrolltime(java.util.Date enrolltime) {
		this.enrolltime = enrolltime;
	}

	public java.util.Date getEnrolltime() {
		return this.enrolltime;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

}



