package com.goosen.commons.dao;

import java.util.List;
import java.util.Map;

import com.goosen.commons.model.po.Orders;
import com.goosen.commons.utils.MyMapper;

/**
 * 订单
 * @author Goosen
 * 2018年7月9日 -下午3:08:52
 */
public interface OrdersMapper extends MyMapper<Orders>{
	
	public List<Map<String, Object>> findByParams(Map<String, Object> params);
	
	public List<String> createOrdersCode(Map<String, Object> params);
    
}
