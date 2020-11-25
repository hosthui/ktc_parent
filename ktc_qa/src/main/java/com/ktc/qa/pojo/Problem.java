package com.ktc.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description 问题实体类
 * @author admin
 * @date 2020-11-25 10:41:11
 */
@Entity
@Table(name="tb_problem")
public class Problem implements Serializable{

	@Id
	private String id;//主键ID

	private String title; //标题
	private String content; //内容
	private java.util.Date createtime; //创建日期
	private java.util.Date updatetime; //修改日期
	private String userid; //用户ID
	private String nickname; //昵称
	private Long visits; //浏览量
	private Long thumbup; //点赞数
	private Long reply; //回复数
	private String solve; //是否解决
	private String replyname; //回复人昵称
	private java.util.Date replytime; //回复日期

	public String getId() {
		return this.id;
	}

	public void setId(String aValue) {
		this.id = aValue;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
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
	public void setVisits(Long visits) {
		this.visits = visits;
	}

	public Long getVisits() {
		return this.visits;
	}
	public void setThumbup(Long thumbup) {
		this.thumbup = thumbup;
	}

	public Long getThumbup() {
		return this.thumbup;
	}
	public void setReply(Long reply) {
		this.reply = reply;
	}

	public Long getReply() {
		return this.reply;
	}
	public void setSolve(String solve) {
		this.solve = solve;
	}

	public String getSolve() {
		return this.solve;
	}
	public void setReplyname(String replyname) {
		this.replyname = replyname;
	}

	public String getReplyname() {
		return this.replyname;
	}
	public void setReplytime(java.util.Date replytime) {
		this.replytime = replytime;
	}

	public java.util.Date getReplytime() {
		return this.replytime;
	}

}



