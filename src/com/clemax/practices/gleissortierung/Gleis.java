package com.clemax.practices.gleissortierung;

import com.clemax.Stack;

public class Gleis {
    private final String name;
    private final Stack<Wagon> wagons;

    public Gleis(String name) {
        this.name = name;
        this.wagons = new Stack<>();
    }

    public String getName() {
        return name;
    }

    public Stack<Wagon> getWagons() {
        return wagons;
    }

    public void deleteTopWagon() {
        wagons.pop();
    }

    public boolean isGleisEmpty() {
        return wagons.isEmpty();
    }

    public void addWagon(Wagon wagon) {
        this.wagons.push(wagon);
    }

    public Wagon getTopWagon() {
        return wagons.top();
    }
}
