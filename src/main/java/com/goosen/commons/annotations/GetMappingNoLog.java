package com.goosen.commons.annotations;

import java.lang.annotation.*;

/**
 * 标识get请求注解，不用统一打印日志
 * @author Goosen
 * @since 2018-05-31 pm
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface GetMappingNoLog {

}
