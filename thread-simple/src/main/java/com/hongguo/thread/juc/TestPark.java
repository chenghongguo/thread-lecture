package com.hongguo.thread.juc;

import java.util.concurrent.locks.LockSupport;

public class TestPark {
    public void testPark() {
//        LockSupport.park();
        LockSupport.park(this);
    }

    public static void main(String[] args) {
        TestPark testPark = new TestPark();
        testPark.testPark();
    }
}
