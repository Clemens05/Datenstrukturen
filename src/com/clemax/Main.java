package com.clemax;

public class Main {

    public static void main(String[] args) {
        System.out.println("Own Queue Testing");
        System.out.println("=================");
        System.out.println();

        OQueue<Integer> queue = new OQueue<>();

        System.out.println("queue.front() = " + queue.front());
        System.out.println("queue.isEmpty() = " + queue.isEmpty());

        Integer i = 1;
        queue.enqueue(i);

        System.out.println("queue.front() = " + queue.front());
        System.out.println("queue.isEmpty() = " + queue.isEmpty());

        Integer j = 5;
        queue.enqueue(j);

        System.out.println("queue.front() = " + queue.front());
        System.out.println("queue.isEmpty() = " + queue.isEmpty());

        queue.dequeue();

        System.out.println("queue.front() = " + queue.front());
        System.out.println("queue.isEmpty() = " + queue.isEmpty());
    }
}
