package com.goosen.commons.dao;

import java.util.List;
import java.util.Map;

import com.goosen.commons.model.po.User;
import com.goosen.commons.utils.MyMapper;

/**
 * 商品
 * @author Goosen
 * 2018年6月27日 -下午3:43:29
 */
public interface UserMapper extends MyMapper<User>{
	
	public List<Map<String, Object>> findByParams(Map<String, Object> params);
    
}
