package com.xhyan.huawei;

import java.util.Scanner;

public class LetterNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextLine()){
            return;
        }
        int result = 0;
        String line1 = scanner.nextLine().trim().toUpperCase();
        String target = scanner.nextLine().toUpperCase();
        if (target.length() > 1){
            throw new RuntimeException("第二行输入的字符长度不能超过1");
        }
        while (line1.contains(target)){
            result++;
            line1 = line1.substring(line1.indexOf(target) + 1);
        }
        System.out.println(result);

    }
}
