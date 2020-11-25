package com.ktc.article.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description 文章实体类
 * @author admin
 * @date 2020-11-25 12:25:17
 */
@Entity
@Table(name="tb_article")
public class Article implements Serializable{

	@Id
	private String id;//主键ID

	private String columnid; //专栏ID
	private String userid; //用户ID
	private String title; //标题
	private String content; //文章正文
	private String image; //文章封面
	private java.util.Date createtime; //发表日期
	private java.util.Date updatetime; //修改日期
	private String ispublic; //是否公开
	private String istop; //是否置顶
	private Integer visits; //浏览量
	private Integer thumbup; //点赞数
	private Integer comment; //评论数
	private String state; //审核状态
	private String channelid; //所属频道
	private String url; //URL
	private String type; //类型

	public String getId() {
		return this.id;
	}

	public void setId(String aValue) {
		this.id = aValue;
	}
	
	public void setColumnid(String columnid) {
		this.columnid = columnid;
	}

	public String getColumnid() {
		return this.columnid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserid() {
		return this.userid;
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
	public void setImage(String image) {
		this.image = image;
	}

	public String getImage() {
		return this.image;
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
	public void setIspublic(String ispublic) {
		this.ispublic = ispublic;
	}

	public String getIspublic() {
		return this.ispublic;
	}
	public void setIstop(String istop) {
		this.istop = istop;
	}

	public String getIstop() {
		return this.istop;
	}
	public void setVisits(Integer visits) {
		this.visits = visits;
	}

	public Integer getVisits() {
		return this.visits;
	}
	public void setThumbup(Integer thumbup) {
		this.thumbup = thumbup;
	}

	public Integer getThumbup() {
		return this.thumbup;
	}
	public void setComment(Integer comment) {
		this.comment = comment;
	}

	public Integer getComment() {
		return this.comment;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}

	public String getChannelid() {
		return this.channelid;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return this.url;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return this.type;
	}

}



