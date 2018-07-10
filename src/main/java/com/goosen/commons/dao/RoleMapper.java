package com.goosen.commons.dao;

import java.util.List;
import java.util.Map;

import com.goosen.commons.model.po.Role;
import com.goosen.commons.utils.MyMapper;

/**
 * 角色
 * @author Goosen
 * 2018年7月5日 -下午6:03:58
 */
public interface RoleMapper extends MyMapper<Role>{
	
	public List<Map<String, Object>> findByParams(Map<String, Object> params);
    
}
