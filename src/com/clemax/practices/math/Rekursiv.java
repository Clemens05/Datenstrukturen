package com.clemax.practices.math;

import java.util.Arrays;

public class Rekursiv {
    public static final int ITERATIV = 0;
    public static final int REKURSIV = 1;

    public Rekursiv() {

    }

    public long fakultaet_iterativ(long n) {
        long result = 1;
        for (int i = 0; i < n; i++) {
            int a = i + 1;
            if (a > 1) {
                result *= a;
            } else {
                result = 1;
            }
        }
        return result;
    }

    public long fakultaet(long n) {
        if (n > 1) {
            return n * (fakultaet(n - 1));
        } else {
            return 1;
        }
    }

    public long fibonacci_iterativ(long n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long vorletzesFib = 0; // fib(i-2) / fib(0) = 0
            long letztesFib = 1;   // fib(i-1) / fib(1) = 1
            long fib = 0;          // fib(i)

            System.out.println("i = " + "null");
            System.out.println("fib = " + fib);
            System.out.println("letztesFib = " + letztesFib);
            System.out.println("vorletzesFib = " + vorletzesFib);
            System.out.println();

            for (int i = 1; i < n; i++) {
                System.out.println("i = " + i);
                System.out.println("fib = " + fib);
                System.out.println("letztesFib = " + letztesFib);
                System.out.println("vorletzesFib = " + vorletzesFib);
                System.out.println();

                fib = letztesFib + vorletzesFib;
                vorletzesFib = letztesFib;
                letztesFib = fib;
            }

            return fib;
        }
    }

    public long fibonacci(long n) {
        if (n > 1) {
            return fibonacci(n - 1) + fibonacci(n - 2);
        } else if (n == 1) {
            return 1;
        } else if (n == 0) {
            return 0;
        }
        return 0;
    }

    public void printFakultaet(int n, int method) {
        double startTime = System.currentTimeMillis();
        long fakultaet = 0;
        String m = "";
        if (method == ITERATIV) {
            fakultaet = fakultaet_iterativ(n);
            m = "iterativ";
        } else if (method == REKURSIV) {
            fakultaet = fakultaet(n);
            m = "rekursiv";
        }
        double endTime = System.currentTimeMillis();

        System.out.println(n + "!" + " = " + fakultaet + " | " + (endTime - startTime) + " Millisek. " + "(" + m + ")");
    }

    public void printFibonacci(int n, int method) {
        double startTime = System.currentTimeMillis();
        long fibonacci = 0;
        String m = "";
        if (method == ITERATIV) {
            fibonacci = fibonacci_iterativ(n);
            m = "iterativ";
        } else if (method == REKURSIV) {
            fibonacci = fibonacci(n);
            m = "rekursiv";
        }
        double endTime = System.currentTimeMillis();

        System.out.println("fib(" + n + ") = " + fibonacci + " | " + (endTime - startTime) + " Millisek. " + "(" + m + ")");
    }
}
