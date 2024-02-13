package ru.java.hw3;

public class Main {
    public static void main(String[] args) throws IllegalStateException, InterruptedException, RuntimeException {
        MyThreadPool pool = new MyThreadPool(3);
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + ": task 1 " + Math.random()));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + ": task 2 " + Math.random()));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + ": task 3 " + Math.random()));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + ": task 4 " + Math.random()));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + ": task 5 " + Math.random()));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + ": task 6 " + Math.random()));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + ": task 7 " + Math.random()));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + ": task 8 " + Math.random()));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + ": task 9 " + Math.random()));
        pool.execute(() -> System.out.println(Thread.currentThread().getName() + ": task 10 " + Math.random()));
        pool.shutdown();
    }
}
