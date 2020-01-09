package com.xhyan.huawei;

/**
 * 两个线程并发调用一个类的print方法,线程A打印1,线程B打印2
 * 顺序输出1 2 1 1 2 1 ...
 * @author yanliwei
 * @date 2020年1月6日
 */
public class MultiThreadPrint {
    static volatile int flag = 1;
    public static void main(String[] args) {
        Print print = new Print();
            Thread t1 = new Thread(() -> {
                int target = 2;
                while (true) {
                    if (target != flag) {
                        print.print(1);
                        flag ++;
                        target += 2;
                    }
                }
            });
            Thread t2 = new Thread(() -> {
                int target = 2;
                while (true) {
                    if (target == flag) {
                        print.print(2);
                        flag ++;
                        target += 2;
                    }
                }
            });
            t1.start();
            t2.start();
    }
}
class Print {
    public void print(int value) {
        System.out.print(value);
    }
}