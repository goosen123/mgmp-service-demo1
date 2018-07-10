package com.goosen.commons.model.response.login;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.goosen.commons.model.response.BaseResp;

@ApiModel(value="登录")
public class LoginRespData extends BaseResp{

	private static final long serialVersionUID = 3536431311056183802L;
	
	@ApiModelProperty(value = "用户id",example="618eb09683d946ddb747a5b8ebc300e4")
	private String id;
	@ApiModelProperty(value = "头像",example="http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg")
	private String avatar;
	@ApiModelProperty(value = "账号",required=true,example="15088132168")
    private String account;
    @ApiModelProperty(value = "用户名称",required=true,example="郭靖")
    private String userName;
    @ApiModelProperty(value = "性别（1：男 2：女 3：未知）",example="1")
    private Integer userSex;
    @ApiModelProperty(value = "邮箱",example="2630344884@qq.com")
    private String userEmail;
    @ApiModelProperty(value = "手机号",example="15088132168")
    private String userPhone;
    @ApiModelProperty(value = "角色id集",example="20a00e3f72a54f91a24cb903ac84083f,cb181c07d0564a5aacda05dc0a801d39")
    private List<String> roleIds;
	
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
	public List<String> getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}
    
}
