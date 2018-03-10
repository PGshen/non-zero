package space.zero.common.jsonLib.annotation;

import java.lang.annotation.*;

/**
 * 用于标注使用JSONlib转换的实体类参数 <br/>
 * 用法 ：methodName(@JsonBeanRequestParam BeanClass data,...)
 * 
 * @author jiabin
 * 
 */
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JsonBeanRequestParam {
	/**
	 * classMap 属性索引列表，必须和 classList的class 位置对应
	 * @return
	 */
	String[] classKeys() default {};

	/**
	 * classMap 属性对应实体类，必须和classKeys的key 位置对应
	 * @return
	 */
	Class[] classList() default {};
}
