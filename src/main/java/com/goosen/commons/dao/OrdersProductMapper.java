package com.goosen.commons.dao;

import java.util.List;
import java.util.Map;

import com.goosen.commons.model.po.OrdersProduct;
import com.goosen.commons.utils.MyMapper;

/**
 * 订单商品
 * @author Goosen
 * 2018年7月10日 -上午9:57:11
 */
public interface OrdersProductMapper extends MyMapper<OrdersProduct>{
	
	public List<Map<String, Object>> findByParams(Map<String, Object> params);
    
}
