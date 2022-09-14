package com.ween.functionalinteface;

/**
 * @author weenhall
 */
public class FunctionalInterfacesExample {
    public static void main(String[] args) {
        Sayable sayable=(msg -> {
            System.out.println(msg);
        });
        sayable.say("Say something");
    }
}
