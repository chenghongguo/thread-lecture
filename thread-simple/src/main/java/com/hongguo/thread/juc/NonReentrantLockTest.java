package com.hongguo.thread.juc;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;

public class NonReentrantLockTest {
    final static NonReentrantLock lock = new NonReentrantLock();
    final static Condition notFull = lock.newCondition();
    final static Condition notEmpty = lock.newCondition();

    final static Queue<String> queue = new LinkedBlockingQueue<>();
    final static int queueSize = 20;

    public static void main(String[] args) {

        lock.unlock();

        Thread producer = new Thread(() -> {
            lock.lock();
            try {
                // 如果队列满了，则等待
                while (queue.size() == queueSize) {
                    notEmpty.await();
                }
                // 添加元素到队列
                queue.add("ele");
                System.out.println("producer ele");

                // 唤醒消费线程
                notFull.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        Thread consumer = new Thread(() -> {
            lock.lock();
            try {
                // 队列空，则等待
                while (queue.size() == 0) {
                    notFull.await();
                }

                // 消费元素
                String ele = queue.poll();
                System.out.println("consumer " + ele);

                // 唤醒生产线程
                notEmpty.signalAll();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });

        producer.start();
        consumer.start();
    }
}
