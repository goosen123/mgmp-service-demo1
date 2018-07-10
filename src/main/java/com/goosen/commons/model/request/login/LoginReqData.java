package com.goosen.commons.model.request.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.hibernate.validator.constraints.NotEmpty;

import com.goosen.commons.model.request.BaseReq;

@ApiModel(value="登录")
public class LoginReqData extends BaseReq{

	private static final long serialVersionUID = 3536431311056183802L;
	
	@ApiModelProperty(value = "账号",required=true,example="15088132168")
	@NotEmpty
    private String account;
	@ApiModelProperty(value = "登录密码",required=true,example="123456")
	@NotEmpty
    private String password;
    @ApiModelProperty(value = "验证码",example="1234")
    private String veriCode;
    
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
	public String getVeriCode() {
		return veriCode;
	}
	public void setVeriCode(String veriCode) {
		this.veriCode = veriCode;
	}
    
}
