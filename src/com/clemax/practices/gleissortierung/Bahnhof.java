package com.clemax.practices.gleissortierung;

public class Bahnhof {
    private final String name;
    private final Gleis[] gleise;

    public Bahnhof(String name, Gleis[] gleise) {
        this.name = name;
        this.gleise = gleise;
    }

    public String getName() {
        return name;
    }

    public void addWagonToGleis(Wagon wagon, String gleisName) {
        for (Gleis gleis : gleise)
            if (gleis.getName().equals(gleisName))
                gleis.addWagon(wagon);
    }

    public Gleis getGleis(String gleisName) {
        for (Gleis gleis : gleise)
            if (gleis.getName().equals(gleisName))
                return gleis;
        return null;
    }
}
