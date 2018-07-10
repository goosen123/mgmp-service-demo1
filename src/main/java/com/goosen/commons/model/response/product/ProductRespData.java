package com.goosen.commons.model.response.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.goosen.commons.model.response.BaseResp;

@ApiModel(value="商品")
public class ProductRespData extends BaseResp{
	
	private static final long serialVersionUID = 3536431311056183802L;
	
	@ApiModelProperty(value = "商品id",example="618eb09683d946ddb747a5b8ebc300e4")
	private String id;
	@ApiModelProperty(value = "商品编号",example="p001")
	private String code;
	@ApiModelProperty(value = "商品封面",example="http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg")
    private String coverPic;
	@ApiModelProperty(value = "商品名称",example="时尚的西裤")
    private String productTitle;
	@ApiModelProperty(value = "商品详情，富文本",example="<p>商品详情</p>")
    private String productDesc;
	@ApiModelProperty(value = "原价,大于0",example="50")
    private Double originalPrice;
	@ApiModelProperty(value = "售价，大于0",example="25")
    private Double salePrice;
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
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
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
	
}
