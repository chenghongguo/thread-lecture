package com.hongguo.thread.simple;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWTest {
    private static volatile CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws Exception {
        list.add("hello")  ;
        list.add("alibaba")  ;
        list.add("welcome")  ;
        list.add("to")  ;
        list.add("hangzhou")  ;

        Thread thread = new Thread(() -> {
            list.set(1, "bab");
            list.remove(2);
            list.remove(3);
        });

        Iterator<String> iterator = list.iterator();

        thread.start();

        thread.join();

        // COW 弱一致性，导致此处输出的是源数据
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
