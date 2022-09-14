package com.ween.lambda;

/**
 * @author weenhall
 */
interface Addable{
    int add(int a,int b);
}
public class JLEExampleMultipleParameters {
    public static void main(String[] args) {
        //without lambda expression
        Addable addable=new Addable() {
            @Override
            public int add(int a, int b) {
                return a+b;
            }
        };
        addable.add(1,2);

        //with lambda expression,without data type in expression
        Addable withLambda=(a,b)->(a+b);
        //with lambda expression,with data type in expression
        Addable withLambdaDatatype=(int a,int b)->(a+b);
        System.out.println(withLambda.add(2,1));
        System.out.println(withLambdaDatatype.add(1,2));
    }
}
