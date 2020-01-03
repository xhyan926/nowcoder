package com.xhyan.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 * 输入描述:
 * 连续输入字符串(输入2次,每个字符串长度小于100)
 * <p>
 * 输出描述:
 * 输出到长度为8的新字符串数组
 * <p>
 * 示例1
 * 输入
 * <p>
 * abc
 * 123456789
 * 输出
 * <p>
 * abc00000
 * 12345678
 * 90000000
 */
public class CharacterSplit {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                continue;
            }
            if (input.length() > 100) {
                throw new RuntimeException("字符串长度不能超过100");
            }
            String surfix = "00000000";
            while (input.length() > 0) {
                if (input.length() <= 8) {
                    result.add(input.concat(surfix).substring(0, 8));
                    input = "";
                } else {
                    result.add(input.substring(0, 8));
                    input = input.substring(8);
                }
            }
        }

        result.forEach(System.out::println);
    }
}
