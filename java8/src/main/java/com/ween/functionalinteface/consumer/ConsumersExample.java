package com.ween.functionalinteface.consumer;

import com.ween.functionalinteface.predefined.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weenhall
 */
public class ConsumersExample {
    public static void main(String[] args) {
        List<Person> listOfPerson = new ArrayList<Person>();
        listOfPerson.add(new Person("abc", 27));
        listOfPerson.add(new Person("mno", 26));
        listOfPerson.add(new Person("pqr", 28));
        listOfPerson.add(new Person("xyz", 27));

        listOfPerson.forEach((person) -> {
            System.out.println(" Person name : " + person.getName());
            System.out.println(" Person age : " + person.getAge());
        });


        // Second example
        Consumer<Person> consumer = (person) -> {
            System.out.println(person.getName());
            System.out.println(person.getAge());
        };
        consumer.accept(new Person("Ramesh", 30));
    }
}
