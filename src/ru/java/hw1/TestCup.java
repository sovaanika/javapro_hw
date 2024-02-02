package ru.java.hw1;

public class TestCup extends Cup {
    @BeforeSuite
    public static void method1() {
    }
    //@BeforeSuite
    public static void method2() {
    }


    @Test(priority = 4)
    public void method3() {
    }

    @Test
    public void method4() {
    }

    @Test(priority = 1)
    public void method5() {
    }

    @Test(priority = 9)
    public void method6() {
    }

    @AfterSuite
    public static void method7() {
    }

    @BeforeTest
    public void beforeTest() {
    }

    @AfterTest
    public void afterTest() {
    }
}
