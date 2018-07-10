package com.goosen.commons.model.response.productattr;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.goosen.commons.model.response.BaseResp;

@ApiModel(value="商品属性")
public class ProductAttrRespData extends BaseResp{
	
	private static final long serialVersionUID = 3536431311056183802L;
	
	@ApiModelProperty(value = "商品属性id",example="618eb09683d946ddb747a5b8ebc300e4")
	private String id;
	@ApiModelProperty(value = "商品属性名称",required=true,example="时尚的西裤")
	private String attrName;
	@ApiModelProperty(value = "属性封面",example="http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg")
    private String attrBrief;
    @ApiModelProperty(value = "原价,大于0",example="50")
    private Double originalPrice;
	@ApiModelProperty(value = "售价，大于0",example="25")
    private Double salePrice;
	@ApiModelProperty(value = "库存",example="51")
    private Integer stockVolume;
    @ApiModelProperty(value = "商品id",example="94f9d13c546d40ed9e6ba2e4674162e2")
    private String productId;
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
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
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
