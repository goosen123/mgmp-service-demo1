package com.goosen.commons.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

/**
 * 校验金额有效性
 * @author Goosen
 * @since 2018-05-31 pm
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MoneyValue.Validator.class)
public @interface MoneyValue {

	String message() default "不是金额形式";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	class Validator implements ConstraintValidator<MoneyValue, Double> {

		 private String moneyReg = "^\\d+(\\.\\d{1,2})?$";//表示金额的正则表达式  
		 private Pattern moneyPattern = Pattern.compile(moneyReg);  

		@Override
		public void initialize(MoneyValue enumValue) {
			;
		}

		@Override
		public boolean isValid(Double value, ConstraintValidatorContext constraintValidatorContext) {
			if (value == null) {
				return Boolean.TRUE;
			}

			return moneyPattern.matcher(value.toString()).matches();
		}
 
	}
}
