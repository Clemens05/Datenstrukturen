package com.clemax.practices.sorting;

import com.clemax.List;

public class QuickSort {
    public static void main(String[] args) {
        List<Integer> list = new List<>();

        list.append(4);
        list.append(9);
        list.append(1);
        list.append(49);
        list.append(10);

        print_list(list);

        List<Integer> newlist = list_quicksort(list);

        print_list(newlist);

    }

    public static List<Integer> list_quicksort(List<Integer> list) {
        list.toFirst();
        if (list.isEmpty()) {
            return list;
        }

        int pivot = list.getContent();

        list.remove();

        if (!list.isEmpty()) {
            print_list(list);
            List<Integer> lower = new List<>();
            List<Integer> higher = new List<>();

            while (!list.isEmpty()) {
                if (list.getContent() < pivot) {
                    lower.append(list.getContent());
                    list.remove();
                } else if (list.getContent() >= pivot) {
                    higher.append(list.getContent());
                    list.remove();
                }
            }

            lower = list_quicksort(lower);
            higher = list_quicksort(higher);
            lower.append(pivot);
            lower.concat(higher);
            return lower;
        }
        return new List<>();
    }

    public static boolean hasOneElement(List<Integer> list) {
        list.toFirst();
        if (list.hasAccess()) {
            list.next();
            return !list.hasAccess();
        }
        return false;
    }

    public static void print_list(List<Integer> list) {
        list.toLast();
        int last = list.getContent();
        list.toFirst();

        String content = "[ ";

        while (list.getContent() != last) {
            content += list.getContent() + " ,";
            list.next();
        }

        System.out.println(content);
    }
}
