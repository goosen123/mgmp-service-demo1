package com.goosen.commons.model.po;

import javax.persistence.Column;

import com.goosen.commons.model.BasePO;

/**
 * 商品属性实体
 * @author Goosen
 * 2018年7月2日 -上午11:45:16
 */
public class ProductAttr extends BasePO{
	
	private static final long serialVersionUID = -7491215402569546437L;
	
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
	@Column(name = "stockVolume")
    private Integer stockVolume;
	@Column(name = "productId")
    private String productId;
	
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
	public Integer getStockVolume() {
		return stockVolume;
	}
	public void setStockVolume(Integer stockVolume) {
		this.stockVolume = stockVolume;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
    
}
