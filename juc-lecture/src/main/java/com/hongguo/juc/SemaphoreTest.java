package com.hongguo.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    private static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() -> {
            System.out.println(Thread.currentThread() + " A task over");
            try {
                semaphore.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            System.out.println(Thread.currentThread() + " A task over");
            try {
                semaphore.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        semaphore.acquire(2);

        executorService.execute(() -> {
            System.out.println(Thread.currentThread() + " B task over");
            try {
                semaphore.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            System.out.println(Thread.currentThread() + " B task over");
            try {
                semaphore.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        semaphore.acquire(2);

        System.out.println("all task over");

        executorService.shutdown();
    }
}
