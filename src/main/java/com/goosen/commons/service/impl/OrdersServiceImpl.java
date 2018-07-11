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
import com.goosen.commons.dao.OrdersProductMapper;
import com.goosen.commons.enums.ResultCode;
import com.goosen.commons.exception.BusinessException;
import com.goosen.commons.model.po.Orders;
import com.goosen.commons.model.po.OrdersProduct;
import com.goosen.commons.model.request.orders.OrdersSubItemReqData;
import com.goosen.commons.service.OrdersProductService;
import com.goosen.commons.service.OrdersService;
import com.goosen.commons.utils.BeanUtil;
import com.goosen.commons.utils.CommonUtil;
import com.goosen.commons.utils.IdGenUtil;
import com.goosen.commons.utils.NumberUtil;

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
    @Autowired
    private OrdersProductService ordersProductService;

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

	@Override
	public Orders submit(List<OrdersSubItemReqData> itemList,List<Map<String, Object>> productList,
			List<Map<String, Object>> productAttrList,Map<String,Object> params) {
		
		Orders record = new Orders();
		//生成订单
		record.setId(IdGenUtil.uuid());
		record.setCode(this.createOrdersCode());
		record.setUserId(CommonUtil.getStrValue(params, "userId"));
		record.setUserName(CommonUtil.getStrValue(params, "userName"));
		record.setTotalCost(CommonUtil.getDoubleValue(params, "totalCost"));
		record.setTotalVolume(CommonUtil.getIntValue(params, "totalVolume"));
		record.setOrderStatus(0);
		record.setIsPay(0);
		record.setOrderRemark(CommonUtil.getStrValue(params, "orderRemark"));
		this.save(record);
		//生成订单商品
		for (int i = 0; i < itemList.size(); i++) {
			OrdersSubItemReqData ordersSubItemReqData = itemList.get(i);
			Integer itemVolume = ordersSubItemReqData.getItemVolume();
			Map<String, Object> productMap = productList.get(i);
			Map<String, Object> productAttrMap = productAttrList.get(i);
			Double salePrice = CommonUtil.getDoubleValue(productAttrMap, "salePrice");
			String productId = CommonUtil.getStrValue(productMap, "id");
			String productAttrId = CommonUtil.getStrValue(productAttrMap, "id");
			OrdersProduct ordersProduct = new OrdersProduct();
			BeanUtil.mapToBean(productMap, ordersProduct);
			BeanUtil.mapToBean(productAttrMap, ordersProduct);
			ordersProduct.setId(IdGenUtil.uuid());
			ordersProduct.setOrderId(record.getId());
			ordersProduct.setProductId(productId);
			ordersProduct.setProductAttrId(productAttrId);
			ordersProduct.setItemVolume(itemVolume);
			ordersProduct.setItemCost(NumberUtil.multi(salePrice, CommonUtil.getDoubleValue(itemVolume), 2));
			ordersProductService.save(ordersProduct);
		}
		//扣减库存，库存不足回滚？？
//		if(true)
//			throw new BusinessException(ResultCode.PARAM_IS_INVALID);
		
		return record;
	}
    
}
