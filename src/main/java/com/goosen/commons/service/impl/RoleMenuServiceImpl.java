package com.goosen.commons.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goosen.commons.model.po.RoleMenu;
import com.goosen.commons.service.RoleMenuService;

/**
 * 角色菜单接口实现
 * @author Goosen
 * 2018年7月5日 -下午11:39:43
 */
@Transactional
@Service
public class RoleMenuServiceImpl extends BaseServiceImpl<RoleMenu> implements RoleMenuService{

}
