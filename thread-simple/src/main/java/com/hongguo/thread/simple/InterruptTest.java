package com.hongguo.thread.simple;

public class InterruptTest {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread() + " hello");
            }
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("main thread interrupt thread");

        // 中断子线程
        thread.interrupt();
        // 等待子线程执行完
        thread.join();

        System.out.println("main is over");
    }
}
