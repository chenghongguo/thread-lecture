package com.hongguo.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SimpleDateFormatTest2 {

    static ThreadLocal<DateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println(threadLocal.get().parse("2017-10-10 12:12:12"));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    threadLocal.remove();
                }
            });
            thread.start();
        }
    }
}
