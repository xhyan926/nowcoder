package com.xhyan.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String output = "";
            List<String> outputList = new ArrayList<>();
            boolean flag = false;
            boolean dotFlag = false;
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c >= '0' && c <= '9') {
                    //字符串开始只能是数字
                    flag = true;
                    output += c;
                } else if (flag) {
                    if (c == '.') {
                        //非开始，可以是.
                        if (!dotFlag) {
                            output += c;
                            dotFlag = true;
                        } else {
                            String[] tmpArray = output.split("\\.");
                            if(tmpArray.length == 2){
                                outputList.add(output);
                                output = tmpArray[1];
                                output += c;
                            }else{
                                outputList.add(tmpArray[0]);
                                flag = false;
                                dotFlag = false;
                                output = "";
                            }
                        }
                    } else {
                        outputList.add(output);
                        flag = false;
                        dotFlag = false;
                        output = "";
                    }
                }

            }
            outputList.add(output);
            String result = "";
            for (String tmp : outputList) {
                if (tmp.length() >= result.length()){
                    result = tmp;
                }
            }
            System.out.println(result);
        }

    }
}
