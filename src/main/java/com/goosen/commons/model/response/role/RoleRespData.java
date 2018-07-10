package com.goosen.commons.model.response.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

import com.goosen.commons.annotations.EnumValue;
import com.goosen.commons.model.request.user.UserReqData.StatusEnum;
import com.goosen.commons.model.request.user.UserReqData.UserSex;
import com.goosen.commons.model.request.user.UserReqData.UserTypeEnum;
import com.goosen.commons.model.response.BaseResp;

@ApiModel(value="角色")
public class RoleRespData extends BaseResp{

	private static final long serialVersionUID = 3536431311056183802L;
	
	@ApiModelProperty(value = "角色id",example="618eb09683d946ddb747a5b8ebc300e4")
	private String id;
	@ApiModelProperty(value = "序号",example="1")
	private Integer num;
	@ApiModelProperty(value = "父角色id",example="0")
    private String pid;
    @ApiModelProperty(value = "角色名称",required=true,example="超级管理员")
	@NotEmpty
    private String name;
    @ApiModelProperty(value = "角色描述",example="拥有所有权限")
    private String tips;
    @ApiModelProperty(value = "创建时间",example="2018-06-29 18:11:08")
	private String createTime;
	@ApiModelProperty(value = "修改时间",example="2018-06-29 18:11:08")
	private String updateTime;

	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
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
