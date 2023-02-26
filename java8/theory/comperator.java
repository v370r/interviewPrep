package java8.theory;

import java.util.*;

class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }
}

class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int nameCompare = p1.getName().compareTo(p2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }
        int ageCompare = Integer.compare(p2.getAge(), p1.getAge());
        if (ageCompare != 0) {
            return ageCompare;
        }
        return Double.compare(p1.getSalary(), p2.getSalary());
    }
}

class Main {
    public static void main(String[] args) {
        Person[] people = {
                new Person("John", 30, 50000),
                new Person("John", 25, 55000),
                new Person("Mary", 25, 60000),
                new Person("Mary", 25, 50000)
        };

        Arrays.sort(people, new PersonComparator());

        for (Person person : people) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getSalary());
        }
    }
}
