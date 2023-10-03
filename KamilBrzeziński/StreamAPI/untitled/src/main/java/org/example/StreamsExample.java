package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsExample {

    List<Employee> employees = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Employee employee1 = new Employee("Cogglesnatch", "Coochierash", 25, List.of("Java", "JavaScript", "Python"));
        Employee employee2 = new Employee("Billyray", "Vegemite", 30, List.of("C#"));
        Employee employee3 = new Employee("Danglerack", "Snickersbar", 23, List.of("Java", "Haskell", "Scala"));
        Employee employee4 = new Employee("Bombadil", "Carrotpatch", 42, List.of("PHP", "JavaScript", "React", "Angular"));
        Employee employee5 = new Employee("Pallettown", "Upperclass", 38, List.of("Java", "Scala"));
        Employee employee6 = new Employee("Burglary", "Moldyspore", 30, List.of("C", "C++"));
        Employee employee7 = new Employee("Dominique", "Cumberbatch", 27, List.of("Rust", "Python"));
        Employee employee8 = new Employee("Benadryl", "Crumplehorn", 51, List.of("Java", "Spring", "Hibernate", "Java"));

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        employees.add(employee8);
    }

    @Test
    public void firstStream() {
        employees.stream()
                .forEach(System.out::println);
    }

    @Test
    public void mapOperation() {
        employees.stream()
                .map(employee -> employee.getFirstName() + " " + employee.getLastName())
                .forEach(System.out::println);
    }

    @Test
    public void flatMapOperation() {
        List<List<String>> allSkills = employees.stream()
                .map(Employee::getSkills)
                .collect(Collectors.toList());

        System.out.println(allSkills);

        List<String> allSkills2 = employees.stream()
                .map(Employee::getSkills)
                .flatMap(list -> list.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(allSkills2);
    }

    @Test
    public void filterOperation() {
        employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("D"))
                .forEach(System.out::println);
    }

    @Test
    public void sortedOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .forEach(System.out::println);

        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .forEach(System.out::println);
    }

    @Test
    public void limitOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void skipOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .skip(2)
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void countOperation() {
        long numberOfEmployees = employees.stream()
                .filter(employee -> employee.getFirstName().startsWith("D"))
                .count();
        System.out.println(numberOfEmployees);
    }

    @Test
    public void minMaxOperation() {
        Employee youngestEmployee = employees.stream()
                .min(Comparator.comparing(Employee::getAge))
                .get();

        System.out.println(youngestEmployee);

        Employee oldestEmployee = employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .get();

        System.out.println(youngestEmployee);
        System.out.println(oldestEmployee);
    }

    @Test
    public void findAnyFindFirstOperations() {
        Employee employee = employees.stream()
                .filter(emp -> emp.getFirstName().startsWith("D"))
                .findFirst()
                .get();

        System.out.println(employee);

        employee = employees.stream()
                .filter(emp -> emp.getFirstName().startsWith("D"))
                .findAny()
                .get();

        System.out.println(employee);
    }

    @Test
    public void matchOperations() {
        Boolean b = employees.stream()
                .allMatch(emp -> emp.getFirstName().startsWith("B"));

        System.out.println(b);

        Boolean b2 = employees.stream()
                .anyMatch(emp -> emp.getFirstName().startsWith("B"));

        System.out.println(b2);

        Boolean b3 = employees.stream()
                .noneMatch(emp -> emp.getFirstName().startsWith("X"));

        System.out.println(b3);
    }

    @Test
    public void reduceOperation() {
         Integer sumOfAllAges = employees.stream()
                 .map(Employee::getAge)
                 .reduce((age1, age2) -> age1 + age2)
                 .get();// .reduce(Integer::sum)

        System.out.println(sumOfAllAges);

        Integer sumOfAllAges2 = employees.stream()
                .map(Employee::getAge)
                .reduce(0, Integer::sum);// .reduce(Integer::sum)

        System.out.println(sumOfAllAges2);

        Integer sumOfAllAges3 = employees.stream()
                .reduce(0, (age, employee) -> age + employee.getAge(), Integer::sum);

        System.out.println(sumOfAllAges3);

        String allNames = employees.stream()
                .map(Employee::getFirstName)
                .reduce((name, name2) -> name + ", " + name2)
                .get();

        System.out.println(allNames);
    }

    @Test
    public void takWhileOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .takeWhile(employee -> employee.getAge() < 30)
                .forEach(System.out::println);
    }

    @Test
    public void dropWhileOperation() {
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .dropWhile(employee -> employee.getAge()<30)
                .forEach(System.out::println);
    }

    @Test
    public void forEachOrdered() {
        String sentence = "Jak nauczyć się programowania";

        sentence.chars().forEach(s -> System.out.print((char)s));
        System.out.println();
        sentence.chars().parallel().forEach(s -> System.out.print((char)s));
        System.out.println();
        sentence.chars().parallel().forEachOrdered(s -> System.out.print((char)s));
    }

    @Test
    public void peekOperation() {
        employees.stream()
                .peek(Employee -> Employee.setFirstName("Kamil"))
                .forEach(System.out::println);
        //Warning: peek modifies original collection. Only for debugging.
    }
}
