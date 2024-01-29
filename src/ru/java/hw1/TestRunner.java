package ru.java.hw1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.*;
import java.util.*;

public class TestRunner {
    public static void runTests(Cup cup) throws IllegalAccessException, InvocationTargetException {
        Class c = cup.getClass();
        Method[] methods = c.getDeclaredMethods();
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;
        List<Method> testMethods = new ArrayList<>();
        for (Method m : methods) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                if (!Modifier.isStatic(m.getModifiers())) {
                    throw new RuntimeException("Аннотация BeforeSuite указана для нестатического метода!");
                }
                if (beforeSuiteMethod != null) {
                    throw new RuntimeException("Неверное количество аннотаций BeforeSuite!");
                }
                beforeSuiteMethod = m;
            }
            else if (m.isAnnotationPresent(AfterSuite.class)) {
                if (!Modifier.isStatic(m.getModifiers())) {
                    throw new RuntimeException("Аннотация AfterSuite указана для нестатического метода!");
                }
                if (afterSuiteMethod != null) {
                    throw new RuntimeException("Неверное количество аннотаций AfterSuite!");
                }
                afterSuiteMethod = m;
            }
            else if (m.isAnnotationPresent(Test.class)) {
                if (Modifier.isStatic(m.getModifiers())) {
                    throw new RuntimeException("Аннотация Test указана для статического метода!");
                }
                testMethods.add(m);
            }
        }
        beforeSuiteMethod.invoke(cup);
        System.out.println("Вызван метод " + beforeSuiteMethod.getName() + " с аннотацией @BeforeSuite");
        Collections.sort(testMethods, (m1, m2) -> {return m2.getAnnotation(Test.class).priority() - m1.getAnnotation(Test.class).priority();});
        for (Method m : testMethods) {
            m.invoke(cup);
            System.out.println("Вызван метод " + m.getName() + " с аннотацией @Test, priority = " + m.getAnnotation(Test.class).priority());
        }
        afterSuiteMethod.invoke(cup);
        System.out.println("Вызван метод " + afterSuiteMethod.getName() + " с аннотацией @AfterSuite");
    }
}
