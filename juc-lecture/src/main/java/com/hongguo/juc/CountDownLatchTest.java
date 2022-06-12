package com.hongguo.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("child thread1 over");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                countDownLatch.countDown();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("child thread2 over");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                countDownLatch.countDown();
            }
        });

        thread1.start();
        thread2.start();

        System.out.println("wait all child thread over!");

        countDownLatch.await();

        System.out.println("all child thread over!");
    }
}
