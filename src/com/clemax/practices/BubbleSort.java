package com.clemax.practices;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[] {1,2,5,2,6,15,52,4};

        for (int k : array) {
            System.out.print("" + k + ",");
        }

        array = betterBubbleSort(array);

        System.out.println();

        for (int j : array) {
            System.out.print("" + j + ",");
        }
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
        int tausch = 0;

        for (int i = 0; i < pArray.length - 1; i++) {
            for (int j = 0; j < pArray.length - 1 - i; j++) {
                if (pArray[j] > pArray[j + 1]) {
                    int temp = pArray[j + 1];
                    pArray[j + 1] = pArray[j];
                    pArray[j] = temp;
                }
            }
        }

        return pArray;
    }
}
