package com.ktc.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description 回答实体类
 * @author admin
 * @date 2020-11-25 10:41:50
 */
@Entity
@Table(name="tb_reply")
public class Reply implements Serializable{

	@Id
	private String id;//主键ID

	private String problemid; //问题ID
	private String content; //回答内容
	private java.util.Date createtime; //创建日期
	private java.util.Date updatetime; //更新日期
	private String userid; //回答人ID
	private String nickname; //回答人昵称

	public String getId() {
		return this.id;
	}

	public void setId(String aValue) {
		this.id = aValue;
	}
	
	public void setProblemid(String problemid) {
		this.problemid = problemid;
	}

	public String getProblemid() {
		return this.problemid;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}
	public void setCreatetime(java.util.Date createtime) {
		this.createtime = createtime;
	}

	public java.util.Date getCreatetime() {
		return this.createtime;
	}
	public void setUpdatetime(java.util.Date updatetime) {
		this.updatetime = updatetime;
	}

	public java.util.Date getUpdatetime() {
		return this.updatetime;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return this.userid;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return this.nickname;
	}

}



