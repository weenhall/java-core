package com.collections.set;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExample {

    public static void main(String[] args) {
        basicOperation();
        comparable();
    }

    public static void basicOperation(){
        SortedSet<Integer> ts=new TreeSet<>();
        ts.add(5);
        ts.add(4);
        ts.add(6);
        ts.add(3);
        ts.add(7);
        ts.forEach(System.out::println);
    }

    //TreeSet比较
    public static void comparable(){
        class Person implements Comparable<Person>{
            int id;
            String name;
            public Person(int id,String name){
                this.id=id;
                this.name=name;
            }
            @Override
            public int compareTo(Person o) {
                return this.name.compareTo(o.name);
            }

            @Override
            public String toString() {
                return this.name;
            }
        }
        SortedSet<Person> people=new TreeSet<>();
        people.add(new Person(1,"AA"));
        people.add(new Person(2,"CC"));
        people.add(new Person(3,"BB"));
        people.forEach(System.out::println);
    }
}
