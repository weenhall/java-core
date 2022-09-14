package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

//解析注解
public class AnnotationParsing {

    public static void main(String[] args) {
        try{
            for(Method method:AnnotationParsing.class.getClassLoader().loadClass("com.annotation.AnnotationExample").getMethods()){
                if(method.isAnnotationPresent(com.annotation.MethodInfo.class)){
                    for(Annotation annotation:method.getDeclaredAnnotations()){
                        System.out.println("Annotation in Method-" +method+"-"+annotation);
                    }
                    MethodInfo methodInfo=method.getAnnotation(MethodInfo.class);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
