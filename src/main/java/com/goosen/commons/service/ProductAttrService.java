package com.goosen.commons.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.goosen.commons.model.po.ProductAttr;

/**
 * 商品属性接口
 * @author Goosen
 * 2018年7月2日 -下午2:07:47
 */
public interface ProductAttrService extends BaseService<ProductAttr>{
    
	List<Map<String,Object>> findByParams(Map<String,Object> params);
    
    PageInfo<Map<String,Object>> findByParamsByPage(Map<String,Object> params);
    
    Map<String,Object> findOneByParams(Map<String,Object> params);
    
//    public void deletProductAttrByProductIds(List<Object> ids);
    
}
