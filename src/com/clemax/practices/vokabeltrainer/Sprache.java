package com.clemax.practices.vokabeltrainer;

public class Sprache {
    private String shortname;
    private String name;

    public Sprache(String shortname, String name) {
        this.shortname = shortname;
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
