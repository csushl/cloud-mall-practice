package com.imooc.cloud.mall.practice.cartorder.util;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 描述：     实现生产者消费者模式
 */
public class MyBlockingQueue {

    public static void main(String[] args) {
        ArrayBlockingQueue<Object> queue = new ArrayBlockingQueue<>(10);

        Runnable producer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        queue.put(new Object());
                        System.out.println("生产者已放置");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(producer).start();

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        queue.take();
                        System.out.println("消费者已消费");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(consumer).start();
    }
}
