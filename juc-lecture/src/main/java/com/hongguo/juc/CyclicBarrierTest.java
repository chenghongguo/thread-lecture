package com.hongguo.juc;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2, () -> {
        System.out.println(Thread.currentThread() + " task1 merge result");
    });

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() -> {
            System.out.println(Thread.currentThread() + " task1-1");
            System.out.println(Thread.currentThread() + " enter in barrier");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " enter out barrier");
        });

        executorService.execute(() -> {
            System.out.println(Thread.currentThread() + " task1-2");
            System.out.println(Thread.currentThread() + " enter in barrier");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " enter out barrier");
        });

        executorService.shutdown();
    }
}
