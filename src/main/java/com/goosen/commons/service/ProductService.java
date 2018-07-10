package com.goosen.commons.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.goosen.commons.model.po.Product;

/**
 * 商品接口
 * @author Goosen
 * 2018年6月27日 -下午4:05:26
 */
public interface ProductService extends BaseService<Product>{
    
	List<Map<String,Object>> findByParams(Map<String,Object> params);
    
	PageInfo<Map<String,Object>> findByParamsByPage(Map<String,Object> params);
    
	Map<String,Object> findOneByParams(Map<String,Object> params);
    
}
