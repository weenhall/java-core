package com.ween.lambda.collection;

import java.util.*;

/**
 * @author weenhall
 */
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class JLEComparatorExample {
    public static void main(String[] args) {
        List<Person> listOfPerson = new ArrayList<Person>();
        listOfPerson.add(new Person("aa", 18));
        listOfPerson.add(new Person("bb", 29));
        listOfPerson.add(new Person("cc", 19));
        System.out.println("before sort");
        System.out.println("==================");
        for (Person person : listOfPerson) {
            System.out.println("Person name:" + person.getName());
        }
        //without lambda expression
        //sort by age
        Comparator<Person> comparator = new Comparator<Person>() {
            @Override
            public int compare(Person p0, Person p1) {
                return p0.getAge() - p1.getAge();
            }
        };
        Collections.sort(listOfPerson, comparator);
        System.out.println("sort persons by age in ascending order");
        System.out.println("==================");
        for (Person person : listOfPerson) {
            System.out.println("Person name:" + person.getName());
        }

        //with lambda expression
        Collections.sort(listOfPerson, (Person p1, Person p2) -> {
            return p1.getAge() - p2.getAge();
        });
        System.out.println("sort persons by age in ascending order with lambda exp.");
        System.out.println("==================");
        listOfPerson.forEach((person -> System.out.println("Person name:" + person.getName())));
    }
}
