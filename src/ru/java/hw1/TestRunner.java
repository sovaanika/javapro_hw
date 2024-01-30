package ru.java.hw1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.*;
import java.util.*;

public class TestRunner {
    public static void runTests(TestCup cup) throws IllegalAccessException, InvocationTargetException {
        Class c = cup.getClass();
        Method[] methods = c.getDeclaredMethods();
        Method beforeSuiteMethod = null;
        Method afterSuiteMethod = null;
        List<Method> testMethods = new ArrayList<>();
        List<Method> beforeTest = new ArrayList<>();
        List<Method> afterTest = new ArrayList<>();
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
                if (m.getAnnotation(Test.class).priority() > 10 || m.getAnnotation(Test.class).priority() < 1) {
                    throw new RuntimeException("Параметр priority для аннотации не в пределах 1-10");
                }
                testMethods.add(m);
            }
            else if (m.isAnnotationPresent(BeforeTest.class)) {
                beforeTest.add(m);
            }
            else if (m.isAnnotationPresent(AfterTest.class)) {
                afterTest.add(m);
            }
        }
        beforeSuiteMethod.invoke(cup);
        System.out.println("Вызван метод " + beforeSuiteMethod.getName() + " с аннотацией @BeforeSuite\n");
        Collections.sort(testMethods, (m1, m2) -> {return m2.getAnnotation(Test.class).priority() - m1.getAnnotation(Test.class).priority();});
        for (Method m : testMethods) {
            for (Method bt : beforeTest) {
                bt.invoke(cup);
                System.out.println("Вызван метод " + bt.getName() + " с аннотацией @BeforeTest");
            }
            m.invoke(cup);
            System.out.println("Вызван метод " + m.getName() + " с аннотацией @Test, priority = " + m.getAnnotation(Test.class).priority());
            for (Method at : afterTest) {
                at.invoke(cup);
                System.out.println("Вызван метод " + at.getName() + " с аннотацией @AfterTest\n");
            }
        }
        afterSuiteMethod.invoke(cup);
        System.out.println("Вызван метод " + afterSuiteMethod.getName() + " с аннотацией @AfterSuite");
    }
}
