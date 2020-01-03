package com.xhyan.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
 *
 * 输入描述:
 * 输入N个字符，字符在ACSII码范围内。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 *
 * 示例1
 * 输入
 *
 * abc
 * 输出
 * 3
 */
public class UnRepeatCharCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.next();
            char[] charArray = input.toCharArray();
            String[] stringArray = new String[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                stringArray[i] = String.valueOf(charArray[i]);
            }
            System.out.println(Arrays.stream(stringArray).distinct().count());
        }
    }
}
