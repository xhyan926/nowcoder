package com.xhyan.huawei;

import java.util.concurrent.Semaphore;

/**
 * 两个线程并发调用一个类的print方法,线程A打印1,线程B打印2
 * 顺序输出1 2 1 1 2 1 ...
 *
 * @author yanliwei
 * @date 2020年1月6日
 */
public class MultiThreadPrint3 {
    public static void main(String[] args) {
        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);
        Print3 print = new Print3();
        Thread t1 = new Thread(() -> {
            while (true) {
                if(semaphore1.availablePermits() > 0) {
                    try {
                        semaphore1.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    print.print(1);
                    if (semaphore1.availablePermits() == 0) {

                        semaphore2.release(1);
                    }
                }

            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                if (semaphore2.availablePermits() > 0) {
                    try {
                        semaphore2.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    print.print(2);
                    semaphore1.release(2);
                }

            }
        });
        t1.start();
        t2.start();
    }
}


class Print3 {
    public void print(int value) {
        System.out.print(value);
    }
}