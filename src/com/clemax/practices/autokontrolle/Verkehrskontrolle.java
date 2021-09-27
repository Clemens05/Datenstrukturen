package com.clemax.practices.autokontrolle;

import com.clemax.OQueue;

public class Verkehrskontrolle {
    private int anzahlAutos;
    private int anzahlMaengel;
    private final OQueue<Fahrzeug> fahrzeuge;
    private final OQueue<Fahrzeug> mangelhafteFahrzeuge;

    public Verkehrskontrolle() {
        this.anzahlAutos = 0;
        this.anzahlMaengel = 0;
        this.fahrzeuge = new OQueue<Fahrzeug>();
        this.mangelhafteFahrzeuge = new OQueue<Fahrzeug>();
    }

    public void kolonneAufloesen() {
        while (!this.fahrzeuge.isEmpty()) {
            if (this.firstFahrzeugUeberpruefen()) {
                this.addMangehafteFahrzeug(this.getFirstFahrzeug());
            }
            this.herauswinken();
        }
    }

    public void herauswinken() {
        this.anzahlAutos--;
        this.fahrzeuge.dequeue();
    }

    public boolean firstFahrzeugUeberpruefen() {
        return this.getFirstFahrzeug().isVerkehrstauglich();
    }

    public int getAnzahlAutos() {
        return anzahlAutos;
    }

    public void setAnzahlAutos(int anzahlAutos) {
        this.anzahlAutos = anzahlAutos;
    }

    public int getAnzahlMaengel() {
        return anzahlMaengel;
    }

    public void setAnzahlMaengel(int anzahlMaengel) {
        this.anzahlMaengel = anzahlMaengel;
    }

    public Fahrzeug getFirstFahrzeug() {
        return this.fahrzeuge.front();
    }

    public void addFahrzeug(Fahrzeug fahrzeug) {
        this.anzahlAutos++;
        this.fahrzeuge.enqueue(fahrzeug);
    }

    public Fahrzeug getFirstMangelhafteFahrzeug() {
        return this.mangelhafteFahrzeuge.front();
    }

    public void addMangehafteFahrzeug(Fahrzeug fahrzeug) {
        this.anzahlMaengel++;
        this.mangelhafteFahrzeuge.enqueue(fahrzeug);
    }

    public boolean fahrzeugeIsEmpty() {
        return this.fahrzeuge.isEmpty();
    }

    public boolean mangelhafteFahrzeugeIsEmpty() {
        return this.mangelhafteFahrzeuge.isEmpty();
    }
}
