package com.clemax.practices.autokontrolle;

import java.awt.*;

public class Fahrzeug {
    private String modell;
    private String farbe;
    private String kennzeichen;
    private boolean verkehrstauglich;

    public Fahrzeug(String modell, String farbe, String kennzeichen, boolean verkehrstauglich) {
        this.modell = modell;
        this.farbe = farbe;
        this.kennzeichen = kennzeichen;
        this.verkehrstauglich = verkehrstauglich;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public boolean isVerkehrstauglich() {
        return verkehrstauglich;
    }

    public void setVerkehrstauglich(boolean verkehrstauglich) {
        this.verkehrstauglich = verkehrstauglich;
    }
}
