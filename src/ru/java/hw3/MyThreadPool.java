package ru.java.hw3;

import java.util.LinkedList;

public class MyThreadPool {
    private final LinkedList<Runnable> taskList;
    private final Worker[] workers;
    private boolean isShutdown = false;


    public MyThreadPool(int capacity) {
        taskList = new LinkedList<>();
        workers = new Worker[capacity];
        for (int i = 0; i < capacity; i++) {
            workers[i] = new Worker("Thread-" + i);
            workers[i].start();
        }
    }

    public void execute(Runnable task) {
        if (workers[0] == null || isShutdown) {
            throw new IllegalStateException("The pool is not initialized or has been shut down.");
        }
        synchronized (taskList) {
            taskList.addLast(task);
            taskList.notify();
        }
    }

    private class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }
        public void run() {
            Runnable task;
            while (true) {
                synchronized(taskList) {
                    while (taskList.isEmpty() && !isShutdown) {
                        try {
                            taskList.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Waiting exception");
                        }
                    }
                    task = taskList.poll();
                    taskList.notifyAll();
                }
                if (task == null && isShutdown) {
                        return ;
                }
                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Running exception");
                }
            }
        }
    }
    public void shutdown() {
        isShutdown = true;
        synchronized (taskList) {
            while (!taskList.isEmpty()) {
                try {
                    taskList.wait();
                } catch (InterruptedException e) {
                    System.out.println("Queue waiting error");
                }
            }
        }
        for (Worker worker : workers) {
            System.out.println("Thread" + worker.getName() + " stopped");
            worker.interrupt();
        }
    }
}
