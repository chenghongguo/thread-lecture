package com.hongguo.thread.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnSafe {
    static final Unsafe unsafe;

    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TestUnSafe testUnSafe = new TestUnSafe();
        boolean b = unsafe.compareAndSwapInt(testUnSafe, stateOffset, 0, 1);
        System.out.println(b);
    }
}
