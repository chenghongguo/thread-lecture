package com.hongguo.thread.juc;

import java.util.concurrent.locks.LockSupport;

public class LockSupportTest2 {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            System.out.println("child thread begin park");
            while(!Thread.currentThread().isInterrupted()) {
                LockSupport.park();
            }
            System.out.println("child threa end park");
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("main thread begin unpark");

//        LockSupport.unpark(thread);

        thread.interrupt();
    }
}
