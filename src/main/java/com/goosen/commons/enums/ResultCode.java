package com.goosen.commons.enums;

import java.util.ArrayList;
import java.util.List;

/**
 * API 统一返回状态码
 * @author Goosen
 * @since 2018-05-31 pm
 */
public enum ResultCode {

	/* 成功状态码 */
	SUCCESS(1, "成功"),

	/* 参数错误：10001-19999 */
	PARAM_IS_INVALID(10001, "参数无效"),
	PARAM_IS_BLANK(10002, "参数为空"),
	PARAM_TYPE_BIND_ERROR(10003, "参数类型错误"),
	PARAM_NOT_COMPLETE(10004, "参数缺失"),

	/* 用户错误：20001-29999*/
	USER_NOT_LOGGED_IN(20001, "用户未登录"),
	USER_LOGIN_ERROR(20002, "账号不存在或密码错误"),
	USER_ACCOUNT_FORBIDDEN(20003, "账号已被禁用"),
	USER_NOT_EXIST(20004, "用户不存在"),
	USER_HAS_EXISTED(20005, "用户已存在"),
	LOGIN_CREDENTIAL_EXISTED(20006, "凭证已存在"),

	/* 业务错误：30001-39999 */
	SPECIFIED_QUESTIONED_USER_NOT_EXIST(30001, "业务错误"),

	/* 系统错误：40001-49999 */
	SYSTEM_INNER_ERROR(40001, "系统繁忙，请稍后重试"), 
 
	/* 数据错误：50001-599999 */
	RESULE_DATA_NONE(50001, "数据未找到"),
	DATA_IS_WRONG(50002, "数据有误"),
	DATA_ALREADY_EXISTED(50003, "数据已存在"),

	/* 接口错误：60001-69999 */
	INTERFACE_INNER_INVOKE_ERROR(60001, "内部系统接口调用异常"),
	INTERFACE_OUTTER_INVOKE_ERROR(60002, "外部系统接口调用异常"),
	INTERFACE_FORBID_VISIT(60003, "该接口禁止访问"),
	INTERFACE_ADDRESS_INVALID(60004, "接口地址无效"),
	INTERFACE_REQUEST_TIMEOUT(60005, "接口请求超时"),
	INTERFACE_EXCEED_LOAD(60006, "接口负载过高"),

	/* 权限错误：70001-79999 */
	PERMISSION_NO_ACCESS(70001, "无访问权限"),
	RESOURCE_EXISTED(70002, "资源已存在"),
	RESOURCE_NOT_EXISTED(70003, "资源不存在"),
	SUPER_ADMIN_UPDATE(70004, "不能修改超级管理员角色"),
	SUPER_ADMIN_DELETE(70005, "不能删除超级管理员角色"),
	
	/* 菜单错误：80001-89999 */
	MENU_PCODE_COINCIDENCE(80001,"菜单编号和父编号不能一致"),
	EXISTED_THE_MENU(80002,"菜单编号重复，不能添加"),
	PMENU_NOT_EXISTED(80003,"父菜单不存在");

	private Integer code;

	private String message;

	ResultCode(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer code() {
		return this.code;
	}

	public String message() {
		return this.message;
	}

	public static String getMessage(String name) {
		for (ResultCode item : ResultCode.values()) {
			if (item.name().equals(name)) {
				return item.message;
			}
		}
		return name;
	}

	public static Integer getCode(String name) {
		for (ResultCode item : ResultCode.values()) {
			if (item.name().equals(name)) {
				return item.code;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return this.name();
	}

	/***
	 * 校验重复的code值
	 */
	static void main(String[] args) {
		ResultCode[] apiResultCodes = ResultCode.values();
		List<Integer> codeList = new ArrayList<Integer>();
		for (ResultCode apiResultCode : apiResultCodes) {
			if (codeList.contains(apiResultCode.code)) {
				System.out.println(apiResultCode.code);
			} else {
				codeList.add(apiResultCode.code());
			}

			System.out.println(apiResultCode.code() + " " + apiResultCode.message());
		}
	}
}
