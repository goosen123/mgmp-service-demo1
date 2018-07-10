package com.goosen.commons.model.po;

import javax.persistence.Column;
import javax.persistence.Table;

import com.goosen.commons.model.BasePO;

/**
 * 用户实体
 * @author Goosen
 * 2018年7月3日 -下午2:46:46
 */
@Table(name = "sys_user")
public class User extends BasePO{
	
	private static final long serialVersionUID = -7491215402569546437L;
	
    private String avatar;
    private String account;
    private String password;
	@Column(name = "userName")
    private String userName;
	@Column(name = "userSex")
    private Integer userSex;
	@Column(name = "userEmail")
    private String userEmail;
	@Column(name = "userPhone")
    private String userPhone;
	@Column(name = "userType")
    private Integer userType;
	@Column(name = "status")
    private Integer status;
	@Column(name = "userMoney")
    private Double userMoney;
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserSex() {
		return userSex;
	}
	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public Integer getUserType() {
		return userType;
	}
	public void setUserType(Integer userType) {
		this.userType = userType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Double getUserMoney() {
		return userMoney;
	}
	public void setUserMoney(Double userMoney) {
		this.userMoney = userMoney;
	}
	
}
