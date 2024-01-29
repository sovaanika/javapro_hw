package ru.java.hw1;

public class Cup {

    private int volume;
    public double price;
    private String color;
    private String image;

    public Cup(int volume, double price, String color, String image) {
        this.volume = volume;
        this.price = price;
        this.color = color;
        this.image = image;
    }

    public Cup() {

    }

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
}
