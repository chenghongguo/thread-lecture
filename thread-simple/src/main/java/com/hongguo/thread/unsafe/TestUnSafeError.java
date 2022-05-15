package com.hongguo.thread.unsafe;

import sun.misc.Unsafe;

public class TestUnSafeError {
    static final Unsafe unsafe = Unsafe.getUnsafe();

    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(TestUnSafeError.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TestUnSafeError testUnSafe = new TestUnSafeError();
        boolean b = unsafe.compareAndSwapInt(testUnSafe, stateOffset, 0, 1);
        System.out.println(b);
    }
}
