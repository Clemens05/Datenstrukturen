package com.clemax.practices.rek;

public class Rek {
    public static void main(String[] args) {
        System.out.println(rekStart(6));
    }

    public static String rekStart(int x) {
        return methA(x, "");
    }

    public static String methA(int n, String s) {
        if (n <= 0) {
            return "";
        } else {
            return "a" + methB(n - 1, s);
        }
    }

    public static String methB(int n, String s) {
        if (n <= 0) {
            return "";
        } else {
            return methA(n - 1, s) + "b";
        }
    }
}
