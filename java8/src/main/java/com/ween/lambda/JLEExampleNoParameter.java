package com.ween.lambda;

/**
 * @author weenhall
 */
interface Sayable{
    String say();
}
public class JLEExampleNoParameter {
    public static void main(String[] args) {
        // without lambda expression
        Sayable sayable=new Sayable() {
            @Override
            public String say() {
                return "without lambda expression: return something ..";
            }
        };
        sayable.say();
        //with lambda expression
        Sayable withLambda=()->{
            return "with lambda expression: return something ..";
        };
        withLambda.say();
    }
}
