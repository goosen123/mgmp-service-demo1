package com.goosen.commons.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goosen.commons.model.po.UserRole;
import com.goosen.commons.service.UserRoleService;

/**
 * 用户角色接口实现
 * @author Goosen
 * 2018年7月6日 -下午3:19:23
 */
@Transactional
@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService{

}
