package com.goosen.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 持久化实体父类
 * @author Goosen
 * 2018年6月27日 -下午2:23:35
 */
public abstract class BasePO implements Serializable{
	
	private static final long serialVersionUID = -7491215402569546437L;
	
	@Id
    private String id;

	@Column(name = "createTime")
    private Date createTime;// = new Date();

	@Column(name = "updateTime")
    private Date updateTime;// = new Date();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
    
}
