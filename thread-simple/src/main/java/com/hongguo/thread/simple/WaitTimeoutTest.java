package com.hongguo.thread.simple;

public class WaitTimeoutTest {
    static Object object = new Object();

    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("begin wait");
                synchronized (object) {
                    object.wait(3000);
                }
                System.out.println("end wait");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread.sleep(1000);
        thread.interrupt();
        thread.join();

        System.out.println("main over");
    }
}
