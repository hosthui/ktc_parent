package com.ktc.user.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description 用户实体类
 * @author admin
 * @date 2020-11-27 16:51:43
 */
@Entity
@Table(name="tb_user")
public class User implements Serializable{

	@Id
	private String id;//主键ID

	private String mobile; //手机号码
	private String password; //密码
	private String nickname; //昵称
	private String sex; //性别
	private java.util.Date birthday; //出生年月日
	private String avatar; //头像
	private String email; //E-Mail
	private java.util.Date regdate; //注册日期
	private java.util.Date updatedate; //修改日期
	private java.util.Date lastdate; //最后登陆日期
	private Long online; //在线时长（分钟）
	private String interest; //兴趣
	private String personality; //个性
	private Integer fanscount; //粉丝数
	private Integer followcount; //关注数

	public String getId() {
		return this.id;
	}

	public void setId(String aValue) {
		this.id = aValue;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile() {
		return this.mobile;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return this.nickname;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSex() {
		return this.sex;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}

	public java.util.Date getBirthday() {
		return this.birthday;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getAvatar() {
		return this.avatar;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}
	public void setRegdate(java.util.Date regdate) {
		this.regdate = regdate;
	}

	public java.util.Date getRegdate() {
		return this.regdate;
	}
	public void setUpdatedate(java.util.Date updatedate) {
		this.updatedate = updatedate;
	}

	public java.util.Date getUpdatedate() {
		return this.updatedate;
	}
	public void setLastdate(java.util.Date lastdate) {
		this.lastdate = lastdate;
	}

	public java.util.Date getLastdate() {
		return this.lastdate;
	}
	public void setOnline(Long online) {
		this.online = online;
	}

	public Long getOnline() {
		return this.online;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getInterest() {
		return this.interest;
	}
	public void setPersonality(String personality) {
		this.personality = personality;
	}

	public String getPersonality() {
		return this.personality;
	}
	public void setFanscount(Integer fanscount) {
		this.fanscount = fanscount;
	}

	public Integer getFanscount() {
		return this.fanscount;
	}
	public void setFollowcount(Integer followcount) {
		this.followcount = followcount;
	}

	public Integer getFollowcount() {
		return this.followcount;
	}

}



