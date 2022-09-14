package com.ween.functionalinteface.supplier;

import com.ween.functionalinteface.predefined.Person;

/**
 * @author weenhall
 */
public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Person> supplier=()->{
          return new Person("smallwhite",25);
        };
        Person p=supplier.get();
        System.out.println(p.getName()+"-"+p.getAge());
    }
}
