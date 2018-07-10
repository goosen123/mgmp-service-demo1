package com.goosen.commons.utils;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


/**
 * 类工具类
 * @author Goosen
 * 2018年6月28日 -上午11:09:33
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class ClassUtil {

	/**
	 * 返回对象的属性数组
	 * Create by ZengJianHua
	 * 2014年3月23日  下午12:23:33
	 * @param o
	 * @return Field []
	 */
	public static Field [] getObjFields(Object o){
		return o.getClass().getDeclaredFields();//getFields();//by Goosen
	}
	
	/**
	 * 返回类的对应的属性名称（key）和对应的类型（value）
	 * Create by ZengJianHua
	 * 2014年3月23日  下午12:23:04
	 * @param o
	 * @return
	 */
	public static Map getClassFieldTypeHash(Object o){
		Field [] fields = getObjFields(o);
		Map fieldInfos = null;
		if(fields.length > 0){
			fieldInfos = new HashMap();
			for(Field field : fields){
				String name = field.getName().toLowerCase();  //属性名称
				String type = field.getType().getSimpleName();     //属性类型名称
				fieldInfos.put(name, type);
			}
		}
		return fieldInfos;
	}
	
	/**
	 * 返回对象的方法名称和方法的映射
	 *            key---方法名称（小写）
	 *            value---Method对象
	 * Create by ZengJianHua
	 * 2014年3月31日  下午10:22:54
	 * @param o
	 * @return
	 */
	public static Map getObjNameMethodMap(Object o){
		Method methods[] = o.getClass().getMethods();
		if(methods.length == 0){
			return null;
		}
		Map methodHt = new HashMap();
		for(Method method : methods){
			String name = method.getName().toLowerCase().trim();
			methodHt.put(name, method);
		}
		return methodHt;
	}
	
	/**
	 * 返回类的对应的属性名称（key）和对应的属性Field对象（value）
	 * Create by ZengJianHua
	 * 2014年3月23日  下午12:23:04
	 * @param o
	 * @return
	 */
	public static Map getObjNameFileMap(Object o){
		Field [] fields = getObjFields(o);
		Map fieldInfos = null;
		if(fields.length > 0){
			fieldInfos = new HashMap();
			for(Field field : fields){
				String name = field.getName().toString().toLowerCase();  //属性名称
				fieldInfos.put(name, field);   //属性Field对象
			}
		}
		return fieldInfos;
	}
	
	/**
	 * 根据参数，返回该类的属性小写为key，value为类Field的对象
	 * Create by ZengJianHua
	 * 2014年3月31日  下午6:27:53
	 * @param o 类对象
	 * @param fieldsStr 属性字符串“,”隔开
	 * @return
	 */
	public static Map getFieldObj(Object o,String fieldsStr){
		if(null == fieldsStr || fieldsStr.trim().length() == 0)
			return null;
		
		//类属性Field对象数组
		Map fields = getObjNameFileMap(o);
		
		if(null == fields || fields.size() == 0)
			return null;
		
		fieldsStr = fieldsStr.replace("，", ",");
		//要更新的field的小写
		String wantFields[] = fieldsStr.split(",");
		
		if(null == wantFields || wantFields.length == 0)
			return null;
		
		Map returnHt = new HashMap();
			
		for(String fieldName : wantFields){//int i = 0; i < wantFields.length; i ++){
			//找到要根性的属性对应的属性对象
			if(null != fields.get(fieldName)){
				returnHt.put(fieldName, fields.get(fieldName));
			}
		}
		return returnHt;
	}
	
	/**
	 * 返回不在参数中类的其他属性的小写字符串“,”隔开
	 * Create by ZengJianHua
	 * 2014年3月31日  下午6:56:26
	 * @param o
	 * @param fieldsStr
	 * @return
	 */
	public static String getNotInFieldStr(Object o, String fieldsStr){
		//类的属性所有小写
		Map fields = getObjNameFileMap(o); 
		if(null == fields || fields.size() == 0)
			return null;
		
		String classFiels = "";
		
		java.util.Set keySet = fields.keySet();
		java.util.Iterator it = keySet.iterator();
		while(it.hasNext()){
			String field = (String) it.next();
			classFiels += field + ",";
		}
		
		if(classFiels.length() == 0){
			return null;
		}
		
		classFiels = classFiels.substring(0,classFiels.length() - 1);
		if(null != fieldsStr && fieldsStr.length()> 0){
			String fieldStrs[] = fieldsStr.split(",");
			for(String field : fieldStrs){ 
				classFiels = classFiels.replace(field, "");
			}
		}
		
		classFiels = classFiels.replace(",,", ",").trim();
		if(classFiels.length() > 0){
			if(classFiels.startsWith(","))
				classFiels = classFiels.substring(1).trim();
			if(classFiels.length() > 0){
				if(classFiels.endsWith(","))
					classFiels = classFiels.substring(0,classFiels.length() - 1);
			}
		}
		return classFiels;
	}
	
	/**
	 * 通过反射执行无参数方法
	 * Create by ZengJianHua
	 * 2014年3月31日  下午10:17:14
	 * @param classname 类全路径名 ，区分大小写
	 * @param methodStr 要执行方法的字符串，不区分大小写
	 * @return 成功true 失败false
	 */
//	public static boolean executeClassMethod(String classname,String methodStr){
//		Object o = null;
//		try {
//			o = Class.forName(classname.trim()).newInstance();
//		} catch (Exception e) {
//			return false;
//		}
//		if(null == o){
//			return false;
//		}
//		Map methods = getObjNameMethodMap(o);
//		Object methodObjec = methods.get(methodStr.toLowerCase().trim());
//		if(null != methodObjec){
//			Method method = (Method) methodObjec;
//			try {
//				method.invoke(o);
//			} catch (Exception e) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	/******************************************************************************************************/
	
	/**
	 * 根据类名扫描类的包全路径
	 * 不区分大小写
	 * Create by ZengJianHua
	 * 2014年4月2日  下午9:55:32
	 * @param startPath 查找开始路径 null则从项目全局查询
	 * @param classname 查找的文件名
	 * @return
	 */
//	public String scanPath(String className,String startPath){
//		if(className.length() == 0){
//			return null;
//		}
//		
//		if(startPath == null){
//			startPath = ".";
//		}
//		try {
//			File file = new File(startPath);
//			return this.findFile(file, className);
//		} catch (Exception e) {
//			return null;
//		}
//	}
	
//	public String scanPath(String className){
//		return this.scanPath(className,null);
//	}
	
//	public String findFile(File file,String findName){
//		File fields[] = file.listFiles();
//		for(File files : fields){ 
//			if(files.isFile()){
//				String name = files.getName();
//				String nameArray[] = name.split("\\.");
//				if(nameArray.length > 0){
//					String tempName = nameArray[0];
//					if(tempName.equals(findName)){
//						String path = files.getAbsolutePath();
//						return path;
//					}
//				}
//			}else{
//				findFile(files,findName);
//			}
//		}
//		return null;
//	}
	
}
