package com.goosen.commons.model.po;

import javax.persistence.Column;

import com.goosen.commons.model.BasePO;

/**
 * 订单实体
 * @author Goosen
 * 2018年7月9日 -下午2:55:29
 */
public class Orders extends BasePO{
	
	private static final long serialVersionUID = -7491215402569546437L;
	
    private String code;
	@Column(name = "userId")
    private String userId;
	@Column(name = "userName")
    private String userName;
	@Column(name = "orderTitle")
    private String orderTitle;
	@Column(name = "totalCost")
    private Double totalCost;
	@Column(name = "totalVolume")
    private Integer totalVolume;
	@Column(name = "orderStatus")
    private Integer orderStatus;
	@Column(name = "isPay")
    private Integer isPay;
	@Column(name = "payWay")
    private Integer payWay;
	@Column(name = "payWayDetail")
    private Integer payWayDetail;
	@Column(name = "orderRemark")
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
	public Integer getIsPay() {
		return isPay;
	}
	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}
	public Integer getPayWay() {
		return payWay;
	}
	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}
	public Integer getPayWayDetail() {
		return payWayDetail;
	}
	public void setPayWayDetail(Integer payWayDetail) {
		this.payWayDetail = payWayDetail;
	}
	public String getOrderRemark() {
		return orderRemark;
	}
	public void setOrderRemark(String orderRemark) {
		this.orderRemark = orderRemark;
	}
	
}
