package com.goosen.commons.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.goosen.commons.model.po.User;

/**
 * 用户接口
 * @author Goosen
 * 2018年7月3日 -下午3:00:30
 */
public interface UserService extends BaseService<User>{
    
	List<Map<String,Object>> findByParams(Map<String,Object> params);
    
    PageInfo<Map<String,Object>> findByParamsByPage(Map<String,Object> params);
    
    Map<String,Object> findOneByParams(Map<String,Object> params);
    
}
