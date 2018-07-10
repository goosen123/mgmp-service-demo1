package com.goosen.commons.model.request.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.hibernate.validator.constraints.NotEmpty;

import com.goosen.commons.annotations.MoneyValue;
import com.goosen.commons.model.request.BaseReq;

@ApiModel(value="商品")
public class ProductReqData extends BaseReq{
	
	private static final long serialVersionUID = 3536431311056183802L;
	
	@ApiModelProperty(value = "商品id",example="618eb09683d946ddb747a5b8ebc300e4")
	private String id;
	@ApiModelProperty(value = "商品编号",example="p001")
	private String code;
	@ApiModelProperty(value = "商品封面",example="http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg")
    private String coverPic;
	@ApiModelProperty(value = "商品轮播图集，用英文逗号隔开",example="http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg,http://onm6xj8b2.bkt.clouddn.com/08422fb4-7d88-4794-bede-2b0cb789a805.jpg")
    private String cyclePic;
	@ApiModelProperty(value = "商品名称",required=true,example="时尚的西裤")
    @NotEmpty
    private String productTitle;
	@ApiModelProperty(value = "商品简介",example="很好很好")
    private String productBrief;
	@ApiModelProperty(value = "商品详情，富文本",example="<p>商品详情</p>")
    private String productDesc;
	@ApiModelProperty(value = "原价,大于0",required=true,example="50")
    @MoneyValue
    private Double originalPrice;
	@ApiModelProperty(value = "售价，大于0",required=true,example="25")
    @MoneyValue
    private Double salePrice;
    
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
	
}
