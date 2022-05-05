package com.hongguo.thread.simple;

public class InterruptedTest {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            for (; ; ) {

            }
        });

        thread.start();

        thread.interrupt();

        // 当前线程（main）中断
        Thread.currentThread().interrupt();

        // 获取中断标志
        System.out.println("isInterrupted:" + thread.isInterrupted());
        // 获取中断标志并重置（去除中断标志）
        System.out.println("isInterrupted:" + thread.interrupted());
        // 获取中断标志并重置
        System.out.println("isInterrupted:" + Thread.interrupted());
        // 获取中断标志
        System.out.println("isInterrupted:" + thread.isInterrupted());

        thread.join();

        System.out.println("main thread is over");
    }
}
