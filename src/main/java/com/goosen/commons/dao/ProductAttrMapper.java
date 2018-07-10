package com.goosen.commons.dao;

import java.util.List;
import java.util.Map;

import com.goosen.commons.model.po.ProductAttr;
import com.goosen.commons.utils.MyMapper;

/**
 * 商品属性
 * @author Goosen
 * 2018年7月2日 -上午11:51:11
 */
public interface ProductAttrMapper extends MyMapper<ProductAttr>{
	
	public List<Map<String, Object>> findByParams(Map<String, Object> params);
    
}
