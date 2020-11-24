package com.ktc.recruit.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description 企业实体类
 * @author admin
 * @date 2020-11-24 20:03:42
 */
@Entity
@Table(name="tb_enterprise")
public class Enterprise implements Serializable{

	@Id
	private String id;//主键ID

	private String name; //企业名称
	private String summary; //企业简介
	private String address; //企业地址
	private String labels; //标签列表
	private String coordinate; //坐标
	private String ishot; //是否热门
	private String logo; //LOGO
	private Integer jobcount; //职位数
	private String url; //URL

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
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}
	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getLabels() {
		return this.labels;
	}
	public void setCoordinate(String coordinate) {
		this.coordinate = coordinate;
	}

	public String getCoordinate() {
		return this.coordinate;
	}
	public void setIshot(String ishot) {
		this.ishot = ishot;
	}

	public String getIshot() {
		return this.ishot;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getLogo() {
		return this.logo;
	}
	public void setJobcount(Integer jobcount) {
		this.jobcount = jobcount;
	}

	public Integer getJobcount() {
		return this.jobcount;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}

}



