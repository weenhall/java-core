package com.annotation;


public class AnnotationExample {

    @Override
    @MethodInfo(author = "weenhall",comments = "重写toString方法",date="2020-01-01",revision = 1)
    public String toString(){
        return "Overwrite toString method";
    }

}
