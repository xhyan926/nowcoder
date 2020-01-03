package com.xhyan.huawei;

import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 *
 * 输入描述:
 * 输入一个正浮点数值
 *
 * 输出描述:
 * 输出该数值的近似整数值
 *
 * 示例1
 * 输入
 * 5.5
 *
 * 输出
 * 6
 */
public class FloatRoundedOff {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextFloat()){
            float input = scanner.nextFloat();
            String[] result = String.valueOf(input).split("\\.");
            System.out.println(Integer.parseInt(result[1]) >=5 ? Integer.parseInt(result[0]) + 1:Integer.parseInt(result[0]));
        }
    }
}
