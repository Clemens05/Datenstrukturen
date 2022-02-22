package com.clemax.practices;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[] {1,2,5,2,6,15,52,4};

        System.out.print("[ ");
        for (int k : array) {
            System.out.print("" + k + ", ");
        }
        System.out.print("]");

        int[] newarray = betterBubbleSort(array);

        System.out.println();

        System.out.print("[ ");
        for (int j : newarray) {
            System.out.print("" + j + ", ");
        }
        System.out.print("]");
    }

    public static int[] bubbleSort(int[] pArray) {
        int tausche = 0;
        for (int i = 0; i < pArray.length; i++) {
            for (int j = 0; j < pArray.length - 1; j++) {
                if (pArray[j] > pArray[j + 1]) {
                    int temp = pArray[j + 1];
                    pArray[j + 1] = pArray[j];
                    pArray[j] = temp;
                    tausche++;
                }
            }
        }

        System.out.println("Anzahl Tausche: " + tausche);

        return pArray;
    }

    public static int[] betterBubbleSort(int[] pArray) {
        int grenze = 0;
        int tausch = pArray.length - 1;

        while (grenze != pArray.length - 1) {
            tausch = pArray.length - 1;
            for (int i = pArray.length - 1; i > grenze; i--) {
                if (pArray[i] < pArray[i - 1]) {
                    tausch = i;
                    int m = pArray[i];
                    pArray[i] = pArray[i - 1];
                    pArray[i - 1] = m;
                }
            }
            grenze = tausch;
        }

        return pArray;
    }
}
