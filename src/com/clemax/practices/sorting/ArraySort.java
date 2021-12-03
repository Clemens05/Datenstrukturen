package com.clemax.practices.sorting;

public class ArraySort {
    private static final int[] werte = new int[] { 2, 3, 7, 11, 5, 1 };
    private static final int INSERTION_SORT = 0;
    private static final int SELECTION_SORT = 1;

    public static void main(String[] args) {
        printWerte();

        sort(SELECTION_SORT);

        printWerte();
    }

    public static void sort(int method) {
        switch (method) {
            case INSERTION_SORT:
                insertion_sort();
            case SELECTION_SORT:
                selection_sort();
        }
    }

    private static void insertion_sort() {
        for (int i = 1; i < werte.length; i++) {
            int current = werte[i];
            int currentPos = i - 1;
            while (currentPos >= 0 && current < werte[currentPos]) {
                werte[currentPos + 1] = werte[currentPos];
                currentPos--;
            }
            werte[currentPos + 1] = current;
        }
    }

    private static void selection_sort() {
        for (int i = 0; i < werte.length - 1; i++) {
            int min = werte[i];
            int pos = i;

            for (int j = i + 1; j < werte.length; j++) {
                if (min > werte[j]) {
                    min = werte[j];
                    pos = j;
                }
            }

            werte[pos] = werte[i];
            werte[i] = min;
        }
    }

    private static String werteToString() {
        String s = "[ ";
        for (int i = 0; i < werte.length; i++) {
            int wert = werte[i];
            s += (wert + (werte.length - 1 != i ? ", " : " "));
        }
        s += "]";

        return s;
    }

    private static void printWerte() {
        System.out.println(werteToString());
    }
}
