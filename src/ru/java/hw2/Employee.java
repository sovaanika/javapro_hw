package ru.java.hw2;

public class Employee {
    private String name;
    private int age;
    private String role;

    public Employee(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public Employee() {
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
