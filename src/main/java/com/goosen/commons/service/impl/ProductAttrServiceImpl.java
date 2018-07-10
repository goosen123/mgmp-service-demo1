package com.goosen.commons.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goosen.commons.dao.ProductAttrMapper;
import com.goosen.commons.model.po.ProductAttr;
import com.goosen.commons.service.ProductAttrService;
import com.goosen.commons.utils.CommonUtil;

/**
 * 商品属性接口实现
 * @author Goosen
 * 2018年7月2日 -下午2:23:32
 */
@Transactional
@Service
public class ProductAttrServiceImpl extends BaseServiceImpl<ProductAttr> implements ProductAttrService{

    @Autowired
    private ProductAttrMapper productAttrMapper;

    @Transactional(readOnly=true)
	@Override
	public List<Map<String, Object>> findByParams(Map<String, Object> params){
		return productAttrMapper.findByParams(params);
	}

    @Transactional(readOnly=true)
	@Override
	public PageInfo<Map<String, Object>> findByParamsByPage(Map<String, Object> params){
		PageHelper.startPage(CommonUtil.getIntValue(params, "pageNum"),CommonUtil.getIntValue(params, "pageSize"));
		List<Map<String, Object>> list = findByParams(params);
		return new PageInfo<Map<String, Object>>(list);
	}

    @Transactional(readOnly=true)
	@Override
	public Map<String, Object> findOneByParams(Map<String, Object> params){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<Map<String, Object>> list = findByParams(params);
		if(list != null && list.size() > 0)
			resultMap = list.get(0);
		return resultMap;
	}

//	@Override
//	public void deletProductAttrByProductIds(List<Object> ids) {
//        if(ids != null && ids.size() > 0){
//        	deleteByIds(ProductAttr.class, "productId", ids);
//        }
//	}
    
}
