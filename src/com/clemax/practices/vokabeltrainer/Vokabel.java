package com.clemax.practices.vokabeltrainer;

public class Vokabel {
    private String word1;
    private String word2;
    private int id;

    public Vokabel(String word1, String word2, int id) {
        this.word1 = word1;
        this.word2 = word2;
        this.id = id;
    }

    public String getWord1() {
        return word1;
    }

    public void setWord1(String word1) {
        this.word1 = word1;
    }

    public String getWord2() {
        return word2;
    }

    public void setWord2(String word2) {
        this.word2 = word2;
    }

    public int getId() {
        return id;
    }
}
