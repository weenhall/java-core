package com.ween.functionalinteface.biconsumer;

import com.ween.functionalinteface.predefined.Person;

/**
 * @author weenhall
 */
public class BiConsumersExample {
    public static void main(String[] args) {

        BiConsumer<Person, Person> biConsumer = (p1, p2) -> {
            System.out.println(" print first persion");
            System.out.println(p1.getName());
            System.out.println(" print second persion");
            System.out.println(p2.getName());
        };

        biConsumer.accept(new Person("Ramesh", 10), new Person("ram", 10));
    }
}
