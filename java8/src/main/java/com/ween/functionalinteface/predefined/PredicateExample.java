package com.ween.functionalinteface.predefined;

/**
 * @author weenhall
 */
public class PredicateExample {
    public static void main(String[] args) {
        Predicate<Person> predicate=(person -> person.getAge()>28);
        boolean result=predicate.test(new Person("smallwhite",29));
        System.out.println(result);
    }
}
