package com.hongguo.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest2 {
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("child thread1 over");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                countDownLatch.countDown();
            }
        });

        executorService.execute(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("child thread2 over");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                countDownLatch.countDown();
            }
        });

        System.out.println("wait all child thread over!");

        countDownLatch.await();

        System.out.println("all child thread over!");

        executorService.shutdown();
    }
}
