package com.hongguo.thread.simple;

public class DeadLockTest {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            synchronized (resourceA) {
                System.out.println("t1 get resourceA lock");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("t1 wait get resourceB");
                synchronized (resourceB) {
                    System.out.println("t1 get resourceB lock");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resourceB) {
                System.out.println("t2 get resourceB lock");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("t2 wait get resourceA");
                synchronized (resourceA) {
                    System.out.println("t2 get resourceA lock");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
