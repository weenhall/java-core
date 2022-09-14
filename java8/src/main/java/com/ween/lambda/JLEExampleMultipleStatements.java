package com.ween.lambda;

/**
 * @author weenhall
 */
interface IAvarage{
    double avg(int [] array);
}
public class JLEExampleMultipleStatements {
    public static void main(String[] args) {
        int array[]={1,3,5,7,9};
        //without lambda expression,IAvarage implementation using anonymous class
        IAvarage avarage=new IAvarage() {
            @Override
            public double avg(int[] array) {
               double sum=0;
               int arraySize=array.length;
                System.out.println("ArraySize:"+arraySize);
                for (int i = 0; i <arraySize ; i++) {
                    sum+=array[i];
                }
                System.out.println("Sum:"+sum);
                return sum/arraySize;
            }
        };
        System.out.println(avarage.avg(array));

        int [] withLamdaArray={2,4,6,8};
        //with a lambda expression,you can pass multiple statements in lambda expression
        IAvarage withLambda=(withLambdaArray)->{
            double sum=0;
            int arraySize=withLambdaArray.length;
            System.out.println("ArraySize:"+arraySize);
            for (int i = 0; i <arraySize ; i++) {
                sum+=withLambdaArray[i];
            }
            System.out.println("Sum:"+sum);
            return sum/arraySize;
        };
        System.out.println(withLambda.avg(withLamdaArray));
    }
}
