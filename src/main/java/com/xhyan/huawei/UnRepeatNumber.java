package com.xhyan.huawei;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 *
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入
 * 9876673
 *
 * 输出
 * 37689
 */
public class UnRepeatNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()){
            int input = scanner.nextInt();
            String temp = String.valueOf(input);
            char[] chars = temp.toCharArray();
            String[] stringArray = new String[chars.length];
            for (int i = 0; i < chars.length; i++) {
                stringArray[chars.length - 1 - i] = String.valueOf(chars[i]);
            }
            System.out.println(Arrays.stream(stringArray).distinct().collect(Collectors.joining()));
        }
    }
}
