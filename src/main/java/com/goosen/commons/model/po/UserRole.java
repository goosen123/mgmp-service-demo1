package com.goosen.commons.model.po;

import javax.persistence.Column;
import javax.persistence.Table;

import com.goosen.commons.model.BasePO;

/**
 * 用户角色实体
 * @author Goosen
 * 2018年7月6日 -下午3:14:16
 */
@Table(name = "sys_user_role")
public class UserRole extends BasePO{
	
	private static final long serialVersionUID = -7491215402569546437L;
	
	@Column(name = "roleId")
    private String roleId;
	@Column(name = "userId")
    private String userId;
    
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}
