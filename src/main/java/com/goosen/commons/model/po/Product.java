package com.goosen.commons.model.po;

import javax.persistence.Column;

import com.goosen.commons.model.BasePO;

/**
 * 商品实体
 * @author Goosen
 * 2018年6月27日 -下午3:41:17
 */
public class Product extends BasePO{
	
	private static final long serialVersionUID = -7491215402569546437L;
	
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
	@Column(name = "originalPrice")
    private Double originalPrice;
	@Column(name = "salePrice")
    private Double salePrice;
	@Column(name = "salesVolume")
    private Integer salesVolume;
    
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
	public Integer getSalesVolume() {
		return salesVolume;
	}
	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}
}
