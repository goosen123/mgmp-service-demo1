package com.goosen.commons.model.request.orders;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import com.goosen.commons.model.request.BaseReq;

@ApiModel(value="订单提交")
public class OrdersSubReqData extends BaseReq{

	private static final long serialVersionUID = 3536431311056183802L;
	
	@ApiModelProperty(value = "用户id",required=true,example="618eb09683d946ddb747a5b8ebc300e4")
	@NotEmpty
	private String userId;
	@ApiModelProperty(value = "订单备注",example="小心轻放")
	private String orderRemark;
	@ApiModelProperty(value = "订单提交条目",required=true,example="[{\"productAttrId\":\"618eb09683d946ddb747a5b8ebc300e4\",\"itemVolume\":2},{\"productAttrId\":\"618eb09683d946ddb747a5b8ebc300e4\",\"itemVolume\":1}]")
	private List<OrdersSubItemReqData> itemList;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	public List<OrdersSubItemReqData> getItemList() {
		return itemList;
	}
	public void setItemList(List<OrdersSubItemReqData> itemList) {
		this.itemList = itemList;
	}
	
}
