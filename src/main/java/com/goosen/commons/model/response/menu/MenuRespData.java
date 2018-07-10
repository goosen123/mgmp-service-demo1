package com.goosen.commons.model.response.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.hibernate.validator.constraints.NotEmpty;

import com.goosen.commons.annotations.EnumValue;
import com.goosen.commons.model.response.BaseResp;

@ApiModel(value="菜单")
public class MenuRespData extends BaseResp{

	private static final long serialVersionUID = 3536431311056183802L;
	
	@ApiModelProperty(value = "菜单id",example="618eb09683d946ddb747a5b8ebc300e4")
	private String id;
	@ApiModelProperty(value = "菜单编号",required=true,example="mgr")
	@NotEmpty
	private String code;
	@ApiModelProperty(value = "父菜单编号",example="system")
	private String pcode;
	@ApiModelProperty(value = "菜单名称",required=true,example="用户管理")
	@NotEmpty
    private String name;
	@ApiModelProperty(value = "头像",example="http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg")
    private String icon;
	@ApiModelProperty(value = "url地址",example="/mgr")
    private String url;
    @ApiModelProperty(value = "菜单排序号",example="1")
    private Integer num;
    @ApiModelProperty(value = "是否是菜单（1：是  0：不是）",example="1")
    @EnumValue(enumClass = IsMenu.class, enumMethod = "isValidCode")
    private Integer ismenu;
    @ApiModelProperty(value = "备注",example="菜单")
    private String tips;
    @ApiModelProperty(value = "菜单状态 : 1:启用   0:不启用",example="1")
    @EnumValue(enumClass = StatusEnum.class, enumMethod = "isValidCode")
    private Integer status;
    @ApiModelProperty(value = "是否打开: 1:打开   0:不打开",example="1")
    @EnumValue(enumClass = IsOpen.class, enumMethod = "isValidCode")
    private Integer isopen;
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
    
    /**
     * 是否是菜单枚举
     */
    public enum IsMenu {
    	NOTMENU(0, "否"),
        YESMENU(1, "是");
        private Integer code;
        private String desc;
        IsMenu(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public Integer getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }
        public static boolean isValidCode(Integer code) {
            if (code == null) {
                return false;
            }
            for (IsMenu status : IsMenu.values()) {
                if (status.getCode().equals(code)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    /**
     * 菜单状态枚举
     */
    public enum StatusEnum {
    	SUSPENDED(0, "不启用"),
        NORMAL(1, "启用");
        private Integer code;
        private String desc;
        StatusEnum(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public Integer getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }
        public static boolean isValidCode(Integer code) {
            if (code == null) {
                return false;
            }
            for (StatusEnum status : StatusEnum.values()) {
                if (status.getCode().equals(code)) {
                    return true;
                }
            }
            return false;
        }
    }
    
    /**
     * 菜单打开枚举
     */
    public enum IsOpen {
    	NOTOPEN(0, "不打开"),
        YESOPEN(1, "打开");
        private Integer code;
        private String desc;
        IsOpen(Integer code, String desc) {
            this.code = code;
            this.desc = desc;
        }
        public Integer getCode() {
            return code;
        }
        public String getDesc() {
            return desc;
        }
        public static boolean isValidCode(Integer code) {
            if (code == null) {
                return false;
            }
            for (IsOpen status : IsOpen.values()) {
                if (status.getCode().equals(code)) {
                    return true;
                }
            }
            return false;
        }
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getIsmenu() {
		return ismenu;
	}

	public void setIsmenu(Integer ismenu) {
		this.ismenu = ismenu;
	}

	public String getTips() {
		return tips;
	}

	public void setTips(String tips) {
		this.tips = tips;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsopen() {
		return isopen;
	}

	public void setIsopen(Integer isopen) {
		this.isopen = isopen;
	}
    
}
