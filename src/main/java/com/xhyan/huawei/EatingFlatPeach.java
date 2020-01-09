package com.xhyan.huawei;

import java.util.Scanner;

/**
 * 孙悟空偷吃蟠桃，天兵天将会离开蟠桃园k小时，求孙悟空在天兵天将回来之前，孙悟空将所有蟠桃吃完的最小吃桃速度，在吃每棵蟠桃树上桃子时，剩下的一个小时内，如果没有可吃的桃子，这一小时内不再吃其他树上的桃子。输入为每棵树上蟠桃数量，以及天兵天将会回来的时间，输出为最小的吃桃速度。
 * 例如：8为8小时后天兵天将会回来
 * input：3，11，6，7，8
 * output：4
 */
public class EatingFlatPeach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            int targetHours = Integer.parseInt(inputArray[inputArray.length - 1]);
            if (inputArray.length - 1 > targetHours) {
                throw new RuntimeException("无法满足条件");
            }
            for (int speed = 1; ; speed++) {
                int hour = 0;
                for (int i = 0; i < inputArray.length - 1; i++) {
                    int count = Integer.parseInt(inputArray[i]);
                    hour += count % speed == 0 ? count / speed : count / speed + 1;
                }
                if (hour > targetHours){
                }else{
                   System.out.println(speed);
                   break;
                }
            }
        }
    }
}
