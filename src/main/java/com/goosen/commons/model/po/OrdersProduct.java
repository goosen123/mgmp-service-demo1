package com.goosen.commons.model.po;

import javax.persistence.Column;

import com.goosen.commons.model.BasePO;

/**
 * 订单商品实体
 * @author Goosen
 * 2018年7月9日 -下午3:00:58
 */
public class OrdersProduct extends BasePO{
	
	private static final long serialVersionUID = -7491215402569546437L;
	
	@Column(name = "orderId")
    private String orderId;
	@Column(name = "productId")
    private String productId;
	private String code;
	@Column(name = "coverPic")
    private String coverPic;
	@Column(name = "cyclePic")
    private String cyclePic;
	@Column(name = "productTitle")
    private String productTitle;
	@Column(name = "productBrief")
    private String productBrief;
	@Column(name = "productDesc")
    private String productDesc;
	@Column(name = "productAttrId")
    private String productAttrId;
	@Column(name = "attrName")
    private String attrName;
	@Column(name = "attrPic")
    private String attrPic;
	@Column(name = "attrBrief")
    private String attrBrief;
	@Column(name = "originalPrice")
    private Double originalPrice;
	@Column(name = "salePrice")
    private Double salePrice;
	@Column(name = "itemVolume")
    private Integer itemVolume;
	@Column(name = "itemCost")
    private Double itemCost;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCoverPic() {
		return coverPic;
	}
	public void setCoverPic(String coverPic) {
		this.coverPic = coverPic;
	}
	public String getCyclePic() {
		return cyclePic;
	}
	public void setCyclePic(String cyclePic) {
		this.cyclePic = cyclePic;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public String getProductBrief() {
		return productBrief;
	}
	public void setProductBrief(String productBrief) {
		this.productBrief = productBrief;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getProductAttrId() {
		return productAttrId;
	}
	public void setProductAttrId(String productAttrId) {
		this.productAttrId = productAttrId;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public String getAttrPic() {
		return attrPic;
	}
	public void setAttrPic(String attrPic) {
		this.attrPic = attrPic;
	}
	public String getAttrBrief() {
		return attrBrief;
	}
	public void setAttrBrief(String attrBrief) {
		this.attrBrief = attrBrief;
	}
	public Double getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(Double originalPrice) {
		this.originalPrice = originalPrice;
	}
	public Double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	public Integer getItemVolume() {
		return itemVolume;
	}
	public void setItemVolume(Integer itemVolume) {
		this.itemVolume = itemVolume;
	}
	public Double getItemCost() {
		return itemCost;
	}
	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}
    
}
