package com.clemax.practices.Einbruchserkennung;

import com.clemax.List;

public class Grundstueck {
    private String strasse;
    private String hausnummer;
    private int gefaehrdungsindex;
    private List<Einbruch> einbrueche;

    public Grundstueck(String strasse, String hausnummer) {
        this.strasse = strasse;
        this.hausnummer = hausnummer;
        einbrueche = new List<>();
    }

    public String getStrasse() {
        return strasse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public int getGefaehrdungsindex() {
        return gefaehrdungsindex;
    }

    public void setGefaehrdungsindex(int gefaehrdungsindex) {
        this.gefaehrdungsindex = gefaehrdungsindex;
    }

    public List<Einbruch> getEinbrueche() {
        return einbrueche;
    }

    public int getAbstand(Grundstueck grundstueck) {
        return 0;
    }

    public void addEinbruch(Einbruch einbruch) {
        einbrueche.append(einbruch);
    }
}
