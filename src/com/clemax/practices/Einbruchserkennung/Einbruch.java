package com.clemax.practices.Einbruchserkennung;

public class Einbruch {
    private boolean aufgeklaert;

    public Einbruch(boolean aufgeklaert) {
        this.aufgeklaert = aufgeklaert;
    }

    public boolean isAufgeklaert() {
        return aufgeklaert;
    }

    public void setAufgeklaert(boolean aufgeklaert) {
        this.aufgeklaert = aufgeklaert;
    }
}
