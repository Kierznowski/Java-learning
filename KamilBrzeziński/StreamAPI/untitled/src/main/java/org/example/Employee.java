package org.example;

import java.sql.SQLOutput;
import java.util.List;

public class Employee {

    private String firstName;
    private String lastName;
    int age;

    private List<String> skills;

    public Employee(String firstName, String lastName, int age, List<String> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.skills = skills;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "name: " + getFirstName() + ", last name: " + getLastName() + ", age: " + getAge() + ", skills: " + getSkills();
    }
}
