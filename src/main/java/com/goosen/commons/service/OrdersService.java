package com.goosen.commons.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.goosen.commons.model.po.Orders;

/**
 * 订单接口
 * @author Goosen
 * 2018年7月10日 -上午10:03:33
 */
public interface OrdersService extends BaseService<Orders>{
    
	List<Map<String,Object>> findByParams(Map<String,Object> params);
    
	PageInfo<Map<String,Object>> findByParamsByPage(Map<String,Object> params);
    
	Map<String,Object> findOneByParams(Map<String,Object> params);
	
	String createOrdersCode();
    
}
