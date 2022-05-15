package com.hongguo.thread.simple;

public class ThreadLocalTest {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static void print(String str) {
        System.out.println(str + ":" + threadLocal.get());
        threadLocal.remove();
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
           threadLocal.set("thread1 local variable");
           threadLocal.set("thread1 local222 variable");
           print("thread1");
            System.out.println("thread1 remove after: " + threadLocal.get());
        });

        Thread thread2 = new Thread(() -> {
            threadLocal.set("thread2 local variable");
            print("thread2");
            System.out.println("thread2 remove after: " + threadLocal.get());
        });

        thread1.start();
        thread2.start();
    }
}
