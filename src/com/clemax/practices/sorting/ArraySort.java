package com.clemax.practices.sorting;

public class ArraySort {
    private int[] werte;
    private String currentSort;
    public final int INSERTION_SORT = 0;
    public final int SELECTION_SORT = 1;
    public final int BUBBLE_SORT = 2;
    public final String BINARY_SEARCH = "BINARY_SEARCH";
    public final String LINEAR_SEARCH = "LINEAR_SEARCH";

    public ArraySort(int[] werte) {
        this.werte = werte;
    }

    public int[] getWerte() {
        return werte;
    }

    public void setWerte(int[] werte) {
        this.werte = werte;
    }

    public String getCurrentSort() {
        return this.currentSort;
    }

    public void sort(int method) {
        switch (method) {
            case INSERTION_SORT:
                currentSort = "INSERTION_SORT";
                insertionSort();
                break;
            case SELECTION_SORT:
                currentSort = "SELECTION_SORT";
                selectionSort();
                break;
            case BUBBLE_SORT:
                currentSort = "BUBBLE_SORT";
                bubbleSort();
                break;
        }
    }

    public boolean search_if_exists(String method, int value) {
        switch (method) {
            case BINARY_SEARCH:
                return binarySearch(value);
            case LINEAR_SEARCH:
                return linearSearch(value);
            default:
                return false;
        }
    }

    private void insertionSort() {
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

    private void selectionSort() {
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

    private void bubbleSort() {
        for (int i = 0; i < werte.length - 1; i++) {
            for (int j = 0; j < werte.length - i - 1; j++) {
                if (werte[j] > werte[j + 1]) {
                    int temp = werte[j];
                    werte[j] = werte[j + 1];
                    werte[j + 1] = temp;
                }
            }
        }
    }

    private boolean linearSearch(int value) {
        for (int i = 0; i < werte.length - 1; i++) {
            if (werte[i] == value) {
                return true;
            }
        }
        return false;
    }

    // (left+right)/2
    private boolean binarySearch(int value) {
        if (werte != null && werte.length > 0) {
            return binarySearch(value, 0, werte.length - 1);
        } else {
            return false;
        }
    }

    private boolean binarySearch(int value, int left, int right) {
        if (left <= right) {
            int center = (left + right) / 2;
            if (value < werte[center]) {
                return binarySearch(value, left, center - 1);
            } else if (value > werte[center]) {
                return binarySearch(value, center + 1, right);
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean isSorted() {
        for (int i = 0; i < werte.length - 1; i++) {
            if (werte[i] > werte[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public String werteToString() {
        String s = "[ ";
        for (int i = 0; i < werte.length; i++) {
            int wert = werte[i];
            s += (wert + (werte.length - 1 != i ? ", " : " "));
        }
        s += "]";

        return s;
    }
}
