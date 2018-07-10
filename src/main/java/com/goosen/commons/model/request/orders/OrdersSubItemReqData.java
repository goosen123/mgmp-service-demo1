package com.goosen.commons.model.request.orders;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;

import com.goosen.commons.model.request.BaseReq;

@ApiModel(value="订单提交条目")
public class OrdersSubItemReqData extends BaseReq{

	private static final long serialVersionUID = 3536431311056183802L;
	
	@ApiModelProperty(value = "商品属性id",required=true,example="618eb09683d946ddb747a5b8ebc300e4")
	@NotEmpty
	private String productAttrId;
	@ApiModelProperty(value = "购买数量",required=true,example="2")
	@Min(1)
	@Max(10000)
	private Integer itemVolume;
	
	public String getProductAttrId() {
		return productAttrId;
	}
	public void setProductAttrId(String productAttrId) {
		this.productAttrId = productAttrId;
	}
	public Integer getItemVolume() {
		return itemVolume;
	}
	public void setItemVolume(Integer itemVolume) {
		this.itemVolume = itemVolume;
	}
	
}
