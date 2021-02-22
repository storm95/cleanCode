package com.ankit.gaurav.ques2;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.*;

enum Gender {
    MALE,
    FEMALE;
}

class Person {
    private final String name;
    private final int age;
    private final Gender gender;

    Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}

class SortPerson implements Comparator<Person> {
    public int compare(Person a, Person b) {
        return a.getAge() - b.getAge();
    }
}

class Implementation {
    public List<Person> getFemaleList(List<Person> persons) {

        return persons.stream().filter(
                person -> {
                    if(person.getGender() == Gender.FEMALE)
                        return true;
                    return false;
                }
        ).collect(Collectors.toList());
    }

    public List<Person> sortPersonByAge(List<Person> persons) {
        List<Person> p = persons;
        Collections.sort(p, new SortPerson());
        return p;
    }
}

public class Source {
    public static void main(String args[]) throws Exception {
        Person p = new Person("Sarah", 25, Gender.FEMALE);
        Person p1 = new Person("Julie", 26, Gender.FEMALE);
        Person p2 = new Person("Sarah", 27, Gender.MALE);

        List<Person> persons = Arrays.asList(p, p1, p2);

        Implementation implementation = new Implementation();
        System.out.println(implementation.getFemaleList(persons));
        System.out.println(implementation.sortPersonByAge(persons));
    }
}
