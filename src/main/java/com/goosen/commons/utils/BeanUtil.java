package com.goosen.commons.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 实体操作工具类
 * @author Goosen
 * 2018年6月28日 -上午10:53:30
 */
public class BeanUtil {
	
	/**
	 * 对非空值进行复制
	 * @param aimObj  目标对象
	 * @param sourceObj  源对象
	 */
	public static void beanCopyNotNull(Object aimObj,Object sourceObj){
		beanCopyExe(aimObj, sourceObj,false,null,null);
	}
	
	/**
	 * 对象值完成复制
	 * @param aimObj 目标对象
	 * @param sourceObj 源对象
	 */
	public static void beanCopyFull(Object aimObj, Object sourceObj){
		beanCopyExe(aimObj, sourceObj,true,null,null);
	}
	
	/**
	 * 在给定字段内进行完成复制
	 * @param aimObj 目标对象
	 * @param sourceObj 源对象
	 * @param fields  复制字段集
	 */
	public static void beanCopyInFieldFull(Object aimObj, Object sourceObj,String fields){
		beanCopyExe(aimObj, sourceObj,true,fields,null);
	}
	
	/**
	 * 对给定字段内进行非空复制
	 * @param aimObj  目标对象
	 * @param sourceObj  源对象
	 * @param fields  复制字段集
	 */
	public static void beanCopyInFieldNotNull(Object aimObj, Object sourceObj,String fields){
		beanCopyExe(aimObj, sourceObj,false,fields,null);
	}
	
	/**
	 * 对给定字段集外的其他字段进行完成复制
	 * @param aimObj  目标对象
	 * @param sourceObj  源对象
	 * @param fields  排除字段集
	 */
	public static void beanCopyUnFieldFull(Object aimObj, Object sourceObj,String fields){
		beanCopyExe(aimObj, sourceObj,true,null,fields);
	}
	
	/**
	 * 对给定字段集外的其他字段进行非空复制
	 * @param aimObj  目标对象
	 * @param sourceObj  源对象
	 * @param fields  排除字段集
	 */
	public static void beanCopyUnFieldNotNull(Object aimObj, Object sourceObj,String fields){
		beanCopyExe(aimObj, sourceObj,false,null,fields);
	}
	
	/**
	 * 进行对象值复制
	 * @param aimObj  目标对象
	 * @param sourceObj  源对象
	 * @param type   null是否复制  true 要， false不要
	 * @param inFields  只复制字段
	 * @param unFields  排除复制字段
	 */
	private static void beanCopyExe(Object aimObj, Object sourceObj,boolean type,String inFields,String unFields){
		List<String> inFieldList = null;
		//只复制字段
		if(inFields != null && inFields.length() > 0){
			inFieldList = new ArrayList<String>();
			String fieldArray[] = inFields.split(",");
			if(fieldArray.length > 0){
				for(String field : fieldArray)
					inFieldList.add(field.toLowerCase());
			}
		}
		
		//不复制字段
		List<String> unFieldList = null;
		if(unFields != null && unFields.length() > 0){
			unFieldList = new ArrayList<String>();
			String fieldArray[] = unFields.split(",");
			if(fieldArray.length > 0){
				for(String field : fieldArray)
					unFieldList.add(field.toLowerCase());
			}
		}
		
		Method []sourceMethods = sourceObj.getClass().getMethods();
		Method []aimMethods = aimObj.getClass().getMethods();
		
		Map<String, Method> aimMethodMap = new HashMap<String, Method>();
		
		for(Method method : aimMethods){
			String methodName = method.getName().toLowerCase();
			aimMethodMap.put(methodName, method);
		}
		
		for(Method method : sourceMethods){
			String methodName = method.getName();
			if(methodName.startsWith("get")){
				Object o = null;
				try {
					o = method.invoke(sourceObj, null);
				} catch (Exception e1) {
					continue;
				}
				//判断获取值是否为null，和是否要复制null值
				if(null == o && !type)
					continue;
				
				String fieldname = methodName.substring(3).toLowerCase();
				
				//判断是否存在要求只复制，或者不复制的字段
				if(null != inFieldList || unFieldList != null){
					if(null != inFieldList){//字段不存在只复制的字段中则不复制
						if(!inFieldList.contains(fieldname))
							continue;
					}else {
						if(unFieldList.contains(fieldname))//字段存在不复制的字段则不复制
							continue;
					}
				}
				String name = "set" + fieldname;
				if(null != aimMethodMap.get(name)){
					Method aimMethod = aimMethodMap.get(name);
					try {
						aimMethod.invoke(aimObj, o);
					} catch (Exception e) {
						continue;
					}
				}
			}
		}
	}
	
	
	/*********************************************************************************************************/
	

	/**
	 * 对象转换map---->object
	 * Create by Goosen
	 * 2018年06月28日  上午11:02:25
	 * @param map 源数据map
	 * @param model  目标对象
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws ParseException 
	 */
	public static String mapToBean(Map map,Object model) {
		 if(model == null || map == null || map.size() == 0)
			 return null;
		 String adt = "";
		 //类的 属性名称---->key  类型---->value
		 Map metaInfos = ClassUtil.getClassFieldTypeHash(model);  
		 //类的 属性名称---->key  属性---->value
		 Map fieldInfos = ClassUtil.getObjNameFileMap(model);  
		 
		 //map的key大小写对应，可以达到大小写不敏感的效果
		 Map infos = new Hashtable();
		 Iterator it = map.keySet().iterator();
		 while(it.hasNext()){
			String value = (String) it.next();
			String key = value.toLowerCase();
			infos.put(key, value);
		 }
		 
		 Iterator modelKeyIt = metaInfos.keySet().iterator();
		 while(modelKeyIt.hasNext()){
			 String key = (String) modelKeyIt.next();
			 if(infos.containsKey(key)){
				String mapKey = (String) infos.get(key);
				Object objValue = map.get(mapKey);
				Field field = (Field) fieldInfos.get(key);
				//关键。。。可访问私有变量   by Goosen
				if(null != field)
					field.setAccessible(true);
				//收集参数跟类匹配到的字段 zjh 2015-02-03 0：44
				if(null != field)
					adt += key + ",";
				//给属性赋值
				setFieldValue(model,field,objValue);
			 }
		 }
		if(adt.length() > 0){
			adt = adt.substring(0,adt.length() - 1);
			return adt;
		}else{
			return null;
		}
	}
	
	
	/**
	 * 对象转换成map返回
	 * Create by ZengJianHua
	 * 2014年3月26日  下午10:09:24
	 * @param object
	 * @return
	 */
	public static Map<String, Object> beanToMap(Object object){
		Map<String, Object> params = new HashMap<String, Object>();
		Field [] fields = ClassUtil.getObjFields(object);
		if(fields.length > 0){
			for(Field field : fields){
				try {
					Object fieldValue = field.get(object);
					if(fieldValue != null){
						String fieldName = field.getName().toLowerCase();
						params.put(fieldName, fieldValue);
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		return params;
	}
	
	/**
	 * 给属性赋值
	 * Create by ZengJianHua
	 * 2014年4月7日  上午9:53:26
	 * @param model  对象
	 * @param field 对象属性
	 * @param o     属性值
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 * @throws ParseException 
	 */
	private static void setFieldValue(Object model,Field field,Object o){
		if(null == model || null == field || null == o){
			return;
		}
		try{
			Type type = field.getGenericType();
			 //是一个引用类型
			 if(type instanceof Class<?>){
					Class<?> cls = (Class<?>)type;
					
					if(String.class.isAssignableFrom(cls)){//String 类型
						String value = CommonUtil.getStrValue(o);
						field.set(model, value);
					}else if(java.util.Date.class.isAssignableFrom(cls) || java.sql.Date.class.isAssignableFrom(cls)){
						if((o instanceof java.util.Date) || (o instanceof java.sql.Date)){//属于date类型
							Date date =(java.util.Date)o;
							field.set(model,date);
						}else{
							if(o instanceof String){
								String timeText = (String)o;
								Date date = DateUtil.convert2Date(timeText, "yyyy-MM-dd HH:mm:ss");//先假设一种格式，by Goosen//DateFormatUtil.getDateByStr(timeText);
								field.set(model,date);
							}
						}
					}else if(int.class.isAssignableFrom(cls) || Integer.class.isAssignableFrom(cls)){//int类型属性
						Integer value = CommonUtil.getIntValue(o);
						field.set(model, value);
					}else if(double.class.isAssignableFrom(cls) || Double.class.isAssignableFrom(cls)){//double类型属性
						Double value = CommonUtil.getDoubleValue(o);
						field.set(model, value);
					}else if(long.class.isAssignableFrom(cls) || Long.class.isAssignableFrom(cls)){//长整形属性	
						Long value = null;
						String lValue = CommonUtil.getStrValue(o);
						if(null != lValue){
							try {
								value = Long.valueOf(lValue);
							} catch (Exception e) {
								value = null;
							}
						}
						field.set(model, value);
					}else if(float.class.isAssignableFrom(cls) || Float.class.isAssignableFrom(cls)){//浮点类型属性	
						Float value = null;
						String fValue = CommonUtil.getStrValue(o);
						if(null != fValue){
							try {
								value = Float.valueOf(fValue);
							} catch (Exception e) {
								value = null;
							}
						}
						field.set(model, value);
					}else if(BigDecimal.class.isAssignableFrom(cls)){ //增加高精度类型识别 ZengJianHua 2014-04-27 00:38
						BigDecimal value = null;
						String bValue = CommonUtil.getStrValue(o);
						if(null != bValue){
							try {
								value = new BigDecimal(bValue);
							} catch (Exception e) {
								value = null;
							}
						}
						field.set(model, value);
						
					}//TODO 添加支持其他数据类型的自动赋值
					else{//属于其他引用类型	
						field.set(model, o);
					}
					
			}
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
