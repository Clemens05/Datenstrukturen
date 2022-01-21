package com.clemax.practices.towersofhanoi;

public class Main {
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String zeug = "\u001B[30m";


    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        System.out.println("turrrrrmmmm baun");
        System.err.println("LOOOL");
        System.out.println("\uD83D\uDE39 ");

        System.out.println(ANSI_BLUE_BACKGROUND
                + zeug
                + "Komm freddi turm bouwn"
                + ANSI_RESET);

        turmUmbau(4, 'A', 'B', 'C');
    }

    public static void turmUmbau(int n, char start, char hilf, char ziel) {
        if (n > 0) {
            turmUmbau(n - 1, start, ziel, hilf);
            System.out.println(n + " von " + start + " nach " + ziel);
            turmUmbau(n - 1, hilf, start, ziel);
        }
    }
}
