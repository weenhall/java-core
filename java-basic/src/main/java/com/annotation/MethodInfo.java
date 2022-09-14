package com.annotation;

import java.lang.annotation.*;
//定义方法级别注解
@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "weenhall";
    String date();
    int revision() default 1;
    String comments();
}
