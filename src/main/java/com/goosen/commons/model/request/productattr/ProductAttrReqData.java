package com.goosen.commons.model.request.productattr;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.hibernate.validator.constraints.NotEmpty;

import com.goosen.commons.annotations.MoneyValue;
import com.goosen.commons.model.request.BaseReq;

@ApiModel(value="商品属性")
public class ProductAttrReqData extends BaseReq{
	
	private static final long serialVersionUID = 3536431311056183802L;
	
	@ApiModelProperty(value = "商品属性id",example="618eb09683d946ddb747a5b8ebc300e4")
	private String id;
	@ApiModelProperty(value = "商品属性名称",required=true,example="时尚的西裤")
	@NotEmpty
	private String attrName;
	@ApiModelProperty(value = "属性封面",example="http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg")
    private String attrPic;
	@ApiModelProperty(value = "商品属性简介",example="很好很好")
    private String attrBrief;
    @ApiModelProperty(value = "原价,大于0",required=true,example="50")
    @MoneyValue
    private Double originalPrice;
	@ApiModelProperty(value = "售价，大于0",required=true,example="25")
    @MoneyValue
    private Double salePrice;
	@ApiModelProperty(value = "库存",required=true,example="51")
    private Integer stockVolume;
    @ApiModelProperty(value = "商品id",required=true,example="94f9d13c546d40ed9e6ba2e4674162e2")
	@NotEmpty
    private String productId;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
