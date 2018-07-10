package com.goosen.commons.model.response.orders;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.goosen.commons.model.response.BaseResp;

@ApiModel(value="订单")
public class OrdersRespData extends BaseResp{
	
	private static final long serialVersionUID = 3536431311056183802L;
	
	@ApiModelProperty(value = "订单号",example="O2018071000001")
	private String code;
	@ApiModelProperty(value = "用户id",example="618eb09683d946ddb747a5b8ebc300e4")
    private String userId;
	@ApiModelProperty(value = "用户名称",example="郭靖")
    private String userName;
	@ApiModelProperty(value = "订单标题",example="哈哈哈")
    private String orderTitle;
	@ApiModelProperty(value = "订单总金额",example="50")
    private Double totalCost;
	@ApiModelProperty(value = "订单数量",example="3")
    private Integer totalVolume;
	@ApiModelProperty(value = "商品订单状态：0待付款 1待发货 2待收货 3待评价 4退款中 5已完成 6已取消 7已退款 8拒绝退款",example="1")
    private Integer orderStatus;
	@ApiModelProperty(value = "订单备注",example="小心轻放")
    private String orderRemark;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOrderTitle() {
		return orderTitle;
	}
	public void setOrderTitle(String orderTitle) {
		this.orderTitle = orderTitle;
	}
	public Double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	public Integer getTotalVolume() {
		return totalVolume;
	}
	public void setTotalVolume(Integer totalVolume) {
		this.totalVolume = totalVolume;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	
}
