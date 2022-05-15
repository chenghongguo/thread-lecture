package com.hongguo.thread.simple;

public class TestForContent2 {
    static final int LINE_NUM = 1024;
    static final int COLUMN_NUM = 1024;

    public static void main(String[] args) {
        long[][] array = new long[LINE_NUM][COLUMN_NUM];

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < LINE_NUM; i++) {
            for (int j = 0; j < COLUMN_NUM; j++) {
                array[j][i] = i * 2 + j;
            }
        }
        System.out.println("cache time:" + (System.currentTimeMillis() - startTime));
    }
}
