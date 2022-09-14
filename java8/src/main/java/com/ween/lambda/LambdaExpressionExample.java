package com.ween.lambda;

/**
 * @author weenhall
 */
interface Drawable{
    void draw();
}
public class LambdaExpressionExample {
    public static void main(String[] args) {
        final int width=10;
        //withoutLambda
        Drawable withoutLambda=new Drawable() {
            public void draw() {
                System.out.println("Drawing withoutLambda:"+width);
            }
        };
        withoutLambda.draw();
        //withLambda
        Drawable withLambda=()->{
            System.out.println("Drawing withLambda:"+width);
        };
        withLambda.draw();
    }
}
