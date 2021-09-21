package com.clemax;

public class Main {

    public static void main(String[] args) {
        stackTesting();
        System.out.println();
        System.out.println();
        queueTesting();
    }

    public static void stackTesting() {
        System.out.println();
        System.out.println(" === Stack Test === ");
        System.out.println();
        System.out.println();

        OStack<Integer> stack = new OStack<>();

        System.out.println("[ Stack nach dem erzeugen");
        System.out.println("[ =======================");
        System.out.println("[ stack.top() = " + stack.top());
        System.out.println("[ stack.isEmpty() = " + stack.isEmpty());
        System.out.println();

        Integer i = 1;
        stack.push(i);

        System.out.println("[ Stack nach push(1)");
        System.out.println("[ ==================");
        System.out.println("[ stack.top() = " + stack.top());
        System.out.println("[ stack.isEmpty() = " + stack.isEmpty());
        System.out.println();

        Integer j = 5;
        stack.push(j);

        System.out.println("[ Stack nach push(5)");
        System.out.println("[ ==================");
        System.out.println("[ stack.top() = " + stack.top());
        System.out.println("[ stack.isEmpty() = " + stack.isEmpty());
        System.out.println();

        stack.pop();

        System.out.println("[ Stack nach pop()");
        System.out.println("[ ================");
        System.out.println("[ stack.top() = " + stack.top());
        System.out.println("[ stack.isEmpty() = " + stack.isEmpty());
        System.out.println();
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

        System.out.println("[ Queue nach dequeue()");
        System.out.println("[ ====================");
        System.out.println("[ queue.front() = " + queue.front());
        System.out.println("[ queue.isEmpty() = " + queue.isEmpty());
        System.out.println();
    }
}
