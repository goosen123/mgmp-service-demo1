package com.goosen.commons.dao;

import java.util.List;
import java.util.Map;

import com.goosen.commons.model.po.Menu;
import com.goosen.commons.utils.MyMapper;

/**
 * 菜单
 * @author Goosen
 * 2018年7月4日 -下午1:46:02
 */
public interface MenuMapper extends MyMapper<Menu>{
	
	public List<Map<String, Object>> findByParams(Map<String, Object> params);
    
}
