package ru.java.hw1;

import java.lang.reflect.*;
import java.util.Arrays;

import static ru.java.hw1.TestRunner.runTests;

public class MyClass {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        //Cup cup = new Cup(300, 250, "green", "flowers");
        Cup cup = new Cup();
        runTests(cup);
    }
}

