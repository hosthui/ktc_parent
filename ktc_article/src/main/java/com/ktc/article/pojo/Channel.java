package com.ktc.article.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description 频道实体类
 * @author admin
 * @date 2020-11-25 12:25:56
 */
@Entity
@Table(name="tb_channel")
public class Channel implements Serializable{

	@Id
	private String id;//主键ID

	private String name; //频道名称
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
	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}

}



