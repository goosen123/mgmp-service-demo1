package com.goosen.commons.model.po;

import javax.persistence.Table;

import com.goosen.commons.model.BasePO;

/**
 * 角色实体
 * @author Goosen
 * 2018年7月5日 -下午6:01:03
 */
@Table(name = "sys_role")
public class Role extends BasePO{
	
	private static final long serialVersionUID = -7491215402569546437L;
	
    private Integer num;
    private String pid;
    private String name;
    private String tips;
    
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	
}
