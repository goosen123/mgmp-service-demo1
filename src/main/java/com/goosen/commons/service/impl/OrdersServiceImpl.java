package com.goosen.commons.service.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.goosen.commons.dao.OrdersMapper;
import com.goosen.commons.model.po.Orders;
import com.goosen.commons.service.OrdersService;
import com.goosen.commons.utils.CommonUtil;

/**
 * 订单接口实现
 * @author Goosen
 * 2018年7月10日 -上午10:05:04
 */
@Transactional
@Service
public class OrdersServiceImpl extends BaseServiceImpl<Orders> implements OrdersService{

    @Autowired
    private OrdersMapper ordersMapper;

    @Transactional(readOnly=true)
	@Override
	public List<Map<String, Object>> findByParams(Map<String, Object> params){
		return ordersMapper.findByParams(params);
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

	@Override
	public synchronized String createOrdersCode() {
		Calendar instance = Calendar.getInstance();
		String year = instance.get(Calendar.YEAR) + "";
		String month = instance.get(Calendar.MONTH) + 1 + "";
		month = month.length() < 2 ? "0" + month : month;
		String day = instance.get(Calendar.DAY_OF_MONTH) + "";
		day = day.length() < 2 ? "0" + day : day;
		String ymd = year + month + day;
		String orderCode = "O" + ymd + "00001";
		//如，O2018040300001
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ymd", ymd);
		List<String> list = ordersMapper.createOrdersCode(params);
		if (list != null && list.size() > 0 && list.get(0) != null) {
			String _orderno = (String) list.get(0);
			Long no = Long.parseLong(_orderno) + 1;
			if (no < 10) {
				orderCode = "O" + year + month + day + "0000" + no + "";
			} else if (no < 100) {
				orderCode = "O" + year + month + day + "000" + no + "";
			} else if (no < 1000) {
				orderCode = "O" + year + month + day + "00" + no + "";
			}else if (no < 10000) {
				orderCode = "O" + year + month + day + "0" + no + "";
			} else {
				orderCode = "O" + year + month + day + no + "";
			}
		}
		return orderCode;
	}
    
}
