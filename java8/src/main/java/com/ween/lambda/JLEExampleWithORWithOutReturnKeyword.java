package com.ween.lambda;

/**
 * @author weenhall
 */
interface Arithmatic{
    int add(int a,int b);
}
public class JLEExampleWithORWithOutReturnKeyword {
    public static void main(String[] args) {
        // without lambda expression
        Arithmatic addable = new Arithmatic() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        addable.add(10, 20);

        // Lambda expression without return keyword.
        Arithmatic withLambda = (a, b) -> (a + b);
        System.out.println(withLambda.add(10, 20));

        // Lambda expression with return keyword.
        Arithmatic arithmatic = (int a, int b) -> {
            return (a + b);
        };
        System.out.println(arithmatic.add(100, 200));
    }
}
