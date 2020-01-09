package com.xhyan.huawei;

import java.util.Scanner;

/**
 * 输入描述:
 * 输入一个字符串。
 * <p>
 * 输出描述:
 * 输出字符串中最长的数字字符串和它的长度。如果有相同长度的串，则要一块儿输出，但是长度还是一串的长度
 * <p>
 * 示例1
 * 输入
 * abcd12345ed125ss123058789
 * <p>
 * 输出
 * 123058789,9
 */
public class ContinuousString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String output = "";
            int length = 0;
            String temp = "";
            int tempLength = 0;
            boolean flag = false;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c >= '0' && c <= '9') {
                    flag = true;
                    temp = temp + c;
                    tempLength++;
                } else if (flag) {
                    if (tempLength > length) {
                        length = tempLength;
                        output = temp;
                    } else if (tempLength == length) {
                        output += temp;
                    }
                    if (i != input.length() - 1) {
                        flag = false;
                        temp = "";
                        tempLength = 0;
                    }
                }
            }
            if (tempLength > length) {
                length = tempLength;
                output = temp;
            } else if (tempLength == length) {
                output += temp;
            }
            System.out.println(output + "," + length);
        }
    }

}
