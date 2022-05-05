package com.hongguo.thread.simple;

public class NotifyTest {
    private static volatile Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(() -> {
            synchronized (object) {
                System.out.println("threadA get resourceA lock");
                try {
                    System.out.println("threadA begin wait");
                    object.wait();
                    System.out.println("threadA end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            synchronized (object) {
                System.out.println("threadB get resourceA lock");
                try {
                    System.out.println("threadB begin wait");
                    object.wait();
                    System.out.println("threadB end wait");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            synchronized (object) {
                System.out.println("threadC begin notify");
                object.notifyAll();
            }
        });

        threadA.start();
        threadB.start();
        //Thread.sleep(1000);
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main over");
    }
}
