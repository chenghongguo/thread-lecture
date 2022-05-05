package com.hongguo.thread.simple;

import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        new Thread(futureTask).start();

        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
