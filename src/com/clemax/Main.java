package com.clemax;

public class Main {

    public static void main(String[] args) {
        queueTesting();
    }

    public static void queueTesting() {
        System.out.println();
        System.out.println(" === Queue Test === ");
        System.out.println();
        System.out.println();

        OQueue<Integer> queue = new OQueue<>();

        System.out.println("[ Queue nach dem erzeugen");
        System.out.println("[ =======================");
        System.out.println("[ queue.front() = " + queue.front());
        System.out.println("[ queue.isEmpty() = " + queue.isEmpty());
        System.out.println();

        Integer i = 1;
        queue.enqueue(i);

        System.out.println("[ Queue nach enqueue(1)");
        System.out.println("[ =====================");
        System.out.println("[ queue.front() = " + queue.front());
        System.out.println("[ queue.isEmpty() = " + queue.isEmpty());
        System.out.println();

        Integer j = 5;
        queue.enqueue(j);

        System.out.println("[ Queue nach enqueue(5)");
        System.out.println("[ =====================");
        System.out.println("[ queue.front() = " + queue.front());
        System.out.println("[ queue.isEmpty() = " + queue.isEmpty());
        System.out.println();

        queue.dequeue();

        System.out.println("[ Queue nach dequeue");
        System.out.println("[ ==================");
        System.out.println("[ queue.front() = " + queue.front());
        System.out.println("[ queue.isEmpty() = " + queue.isEmpty());
        System.out.println();
    }
}
