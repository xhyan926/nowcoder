package com.xhyan.huawei;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 两个线程并发调用一个类的print方法,线程A打印1,线程B打印2
 * 顺序输出1 2 1 1 2 1 ...
 * @author yanliwei
 * @date 2020年1月6日
 */
public class MultiThreadPrint2 {
    public static void main(String[] args) {
        Print2 print = new Print2();
        Runnable task1 = () -> print.print(1);
        Runnable task2 = () -> print.print(2);
        //创建容量为1的线程池模拟实现生产者消费者模式
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        while (true){
            //循环按顺序提交任务
            executor.submit(task1);
            executor.submit(task2);
            executor.submit(task1);
        }
    }
}

class Print2 {
    public void print(int value) {
        System.out.print(value);
    }
}