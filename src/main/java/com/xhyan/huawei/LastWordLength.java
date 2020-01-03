package com.xhyan.huawei;

import java.util.Scanner;

/**
 * 1、字符串最后一个单词的长度
 *
 * 题目描述：计算字符串最后一个单词的长度，单词以空格隔开。
 *
 * 例如：输入Hello World，输出5。
 */
public class LastWordLength {

    public static void main(String[] args) {
        //获取键盘输入
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()){
            return;
        }
        String s = scanner.nextLine();
        int length = s.length();
        if(length >= 5000){
            throw new RuntimeException("输入字符串长度不能超过5000");
        }
        int lastWordStart = s.lastIndexOf(' ');
        if (-1 == lastWordStart){
            System.out.println(length);
        }else{
            System.out.println(length - lastWordStart -1 );
        }


    }
}
