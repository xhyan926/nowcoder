package com.xhyan.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cny_hdk = 0;
        int usd_cny = 0;
        int gbp_usd = 0;
        int count = 0;
        String money = "";
        String method = "";
        List<String> checkList = new ArrayList<>();
        checkList.add("HKD");
        checkList.add("CNY");
        checkList.add("USD");
        checkList.add("GBP");
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            if (inputArray.length != 6) {
                System.out.println("ERROR");
                return;
            }

            for (int i = 0; i < 4; i++) {
                if (!checkNumber(inputArray[i])) {
                    System.out.println("ERROR");
                    return;
                }
            }
            cny_hdk = Integer.parseUnsignedInt(inputArray[0]);
            usd_cny = Integer.parseUnsignedInt(inputArray[1]);
            gbp_usd = Integer.parseUnsignedInt(inputArray[2]);
            count = Integer.parseUnsignedInt(inputArray[3]);
            if (!checkList.contains(inputArray[4])) {
                System.out.println("ERROR");
                return;
            }
            money = inputArray[4];
            if (!(inputArray[5].equals("MIN") || inputArray[5].equals("MAX"))) {
                System.out.println("ERROR");
                return;
            }
            method = inputArray[5];

            if (method.equals("MIN")) {
                if (money.equals("GBP")) {
                    count = count * gbp_usd;
                    money = "USD";
                }
                if (money.equals("USD")) {
                    count = count * usd_cny;
                    money = "CNY";
                }
                if (money.equals("CNY")) {
                    count = count * cny_hdk;
                    money = "HKD";
                }
                if (money.equals("HKD")) {
                    System.out.println(count + " " + "HKD");
                }
            } else {
                List<String> result = new ArrayList<>();
                if (money.equals("HKD")) {
                    int left = count % cny_hdk;
                    if (left > 0) {
                        result.add(left + " " + "HKD");
                    }
                    count = count / cny_hdk;
                    if (count > 0) {
                        money = "CNY";
                    }
                }
                if (money.equals("CNY")) {
                    int left = count % usd_cny;
                    if (left > 0) {
                        result.add(left + " " + "CNY");
                    }
                    count = count / usd_cny;
                    if (count > 0) {
                        money = "USD";
                    }
                }
                if (money.equals("USD")) {
                    int left = count % gbp_usd;
                    if (left > 0) {
                        result.add(left + " " + "USD");
                    }
                    count = count / gbp_usd;
                    if (count > 0) {
                        money = "GBP";
                    }
                }
                if (money.equals("GBP")) {
                    result.add(count + " " + "GBP");
                }
                for (int i = result.size() - 1; i >= 0; i--) {
                    System.out.print(result.get(i));
                    if (i > 0) {
                        System.out.print(" ");
                    }
                }
            }

        }
    }

    public static boolean checkNumber(String n) {
        try {
            int i = Integer.parseUnsignedInt(n);
            if (i <= 0) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
