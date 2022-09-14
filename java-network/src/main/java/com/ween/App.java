package com.ween;


/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        try {
            for (int i = 0; i < 5000; i++) {
                System.out.println("nums:" + i);
                if (i == 4999) {
                    System.out.println("结束");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
