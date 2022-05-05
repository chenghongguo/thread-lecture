package com.hongguo.thread.simple;

public class WaitNotifyInterrupt {
    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->  {
            try {
                System.out.println("---begin---");
                synchronized (object) {
                    // 阻塞当前线程
                    object.wait();
                }
                System.out.println("---end---");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();

        Thread.sleep(1000);

        System.out.println("---begin interrupt thead---");
        thread.interrupt();
        System.out.println("---end interrupt thead---");
    }
}
