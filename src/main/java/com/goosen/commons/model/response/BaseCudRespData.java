package com.goosen.commons.model.response;


/**
 * 增删改通用响应实体
 * @author Goosen
 * 2018年6月27日 -下午4:33:33
 */
public class BaseCudRespData<T> extends BaseResp {

	private static final long serialVersionUID = 3536431311056183802L;
	
	private T id;

	public T getId() {
		return id;
	}

	public void setId(T id) {
		this.id = id;
	}
	
}
