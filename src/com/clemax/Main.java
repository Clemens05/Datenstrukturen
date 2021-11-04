package com.clemax;

import com.clemax.practices.gleissortierung.Bahnhof;
import com.clemax.practices.gleissortierung.Gleis;
import com.clemax.practices.gleissortierung.Wagon;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        OList<String> list = new OList<>();
        list.append("eins");
        list.append("zwei");
        list.append("drei");

        list.toFirst();
        list.next();

        list.insert("vier");

        list.toFirst();
        System.out.println(list.getContent());

        list.next();
        System.out.println(list.getContent());

        list.next();
        System.out.println(list.getContent());

        list.next();
        System.out.println(list.getContent());

        list.next();
        System.out.println(list.getContent());

        list.next();
        System.out.println(list.getContent());

        System.out.println(list.getContent());
    }

    public static void bahnhof() {
        Gleis gleisC = new Gleis("B");
        gleisC.addWagon(new Wagon(14));
        gleisC.addWagon(new Wagon(11));
        gleisC.addWagon(new Wagon(16));
        gleisC.addWagon(new Wagon(13));
        gleisC.addWagon(new Wagon(18));
        gleisC.addWagon(new Wagon(15));

        Bahnhof bahnhof = new Bahnhof("Paderborn Hbf", new Gleis[] {
                new Gleis("A"),
                gleisC,
                new Gleis("C"),
        });

        while (!bahnhof.getGleis("A").isGleisEmpty()) {
            System.out.println("Gleis A ist leer");
            if (bahnhof.getGleis("C").isGleisEmpty()) {
                System.out.println("C ist leer");
                bahnhof.getGleis("C").addWagon(bahnhof.getGleis("A").getTopWagon());
                bahnhof.getGleis("A").deleteTopWagon();
                System.out.println("Von A nach C verschoben");
            } else if (bahnhof.getGleis("A").getTopWagon().getNr() < bahnhof.getGleis("C").getTopWagon().getNr()) {
                System.out.println("A < C");
                bahnhof.getGleis("C").addWagon(bahnhof.getGleis("B").getTopWagon());
                bahnhof.getGleis("B").getTopWagon();
                System.out.println("Von C nach B verschoben");
            } else if (!bahnhof.getGleis("B").isGleisEmpty()) {
                System.out.println("B ist leer");
                if (bahnhof.getGleis("A").getTopWagon().getNr() > bahnhof.getGleis("B").getTopWagon().getNr()) {
                    System.out.println("A > C");
                    bahnhof.getGleis("C").addWagon(bahnhof.getGleis("B").getTopWagon());
                    bahnhof.getGleis("B").deleteTopWagon();
                    System.out.println("Von B nach C geschoben");
                } else {
                    System.out.println("B ist nicht leer");
                    bahnhof.getGleis("C").addWagon(bahnhof.getGleis("A").getTopWagon());
                    bahnhof.getGleis("A").deleteTopWagon();
                    System.out.println("Von A nach C verschoben");
                }
            } else {
                System.out.println("nix von dem");
            }
        }

        System.out.println(bahnhof.getGleis("B").getTopWagon().getNr());

        /*
        System.out.println(bahnhof.getGleis("C").getTopWagon().getNr());
        bahnhof.getGleis("C").deleteTopWagon();
        System.out.println(bahnhof.getGleis("C").getTopWagon().getNr());
        bahnhof.getGleis("C").deleteTopWagon();
        System.out.println(bahnhof.getGleis("C").getTopWagon().getNr());
        bahnhof.getGleis("C").deleteTopWagon();
        System.out.println(bahnhof.getGleis("C").getTopWagon().getNr());
        bahnhof.getGleis("C").deleteTopWagon();
        System.out.println(bahnhof.getGleis("C").getTopWagon().getNr());
        bahnhof.getGleis("C").deleteTopWagon();
        System.out.println(bahnhof.getGleis("C").getTopWagon().getNr());
        bahnhof.getGleis("C").deleteTopWagon();
         */

        /*
        while (!bahnhof.getGleisA().isEmpty()) {
            if (bahnhof.getGleisC().isEmpty()) {
                bahnhof.getGleisC().push(bahnhof.getGleisA().top());
                bahnhof.getGleisA().pop();
            } else if (bahnhof.getGleisA().top().getNr()< bahnhof.getGleisC().top().getNr()) {
                bahnhof.getGleisC().push(bahnhof.getGleisB().top());
                bahnhof.getGleisB().pop();
            } else if (!bahnhof.getGleisB().isEmpty()) {
                if (bahnhof.getGleisA().top().getNr() > bahnhof.getGleisB().top().getNr()) {
                    bahnhof.getGleisC().push(bahnhof.getGleisB().top());
                    bahnhof.getGleisB().pop();
                } else {
                    // A nach C
                }
            }
        }
        */

        /*
        stackTesting();
        System.out.println();
        System.out.println();
        queueTesting();
         */
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
