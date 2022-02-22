package com.clemax.practices.sorting;

public class SortArray {
    private int[] array;
    private String currentSort;
    public final String INSERTION_SORT = "INSERTION_SORT";
    public final String SELECTION_SORT = "SELECTION_SORT";
    public final String BUBBLE_SORT = "BUBBLE_SORT";
    public final String QUICK_SORT = "QUICK_SORT";
    public final String LINEAR_SEARCH = "LINEAR_SEARCH";
    public final String BINARY_SEARCH = "BINARY_SEARCH";

    public SortArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public String getCurrentSort() {
        return currentSort;
    }

    public void sort(String method) {
        switch (method) {
            case INSERTION_SORT -> {
                currentSort = INSERTION_SORT;
                insertionSort();
            }
            case SELECTION_SORT -> {
                currentSort = SELECTION_SORT;
                selectionSort();
            }
            case BUBBLE_SORT -> {
                currentSort = BUBBLE_SORT;
                bubbleSort();
            }
        }
    }

    private void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int currentPos = i - 1;
            while (currentPos >= 0 && current < array[currentPos]) {
                array[currentPos + 1] = array[currentPos];
                currentPos--;
            }
            array[currentPos + 1] = current;
        }
    }

    private void selectionSort() {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int pos = i;

            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    pos = j;
                }
            }

            array[pos] = array[i];
            array[i] = min;
        }
    }

    private void bubbleSort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
