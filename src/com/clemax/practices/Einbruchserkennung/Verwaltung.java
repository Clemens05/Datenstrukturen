package com.clemax.practices.Einbruchserkennung;

import com.clemax.List;

public class Verwaltung {
    private List<Grundstueck> grundstuecke;

    public Verwaltung() {
        grundstuecke = new List<>();
        grundstuecke.append(new Grundstueck("Musterstrasse", "1a"));
        grundstuecke.append(new Grundstueck("Musterstrasse", "1b"));
        grundstuecke.append(new Grundstueck("Musterstrasse", "2"));
        grundstuecke.append(new Grundstueck("Musterstrasse", "4"));
        grundstuecke.append(new Grundstueck("Musterstrasse", "10"));
    }

    public Grundstueck getGrundstueck(String strasse, String hausnummer) {
        grundstuecke.toFirst();
        while (grundstuecke.hasAccess()) {
            if (strasse.equals(grundstuecke.getContent().getStrasse()) && hausnummer.equals(grundstuecke.getContent().getHausnummer())) {
                return grundstuecke.getContent();
            }
            grundstuecke.next();
        }

        return null;
    }

    public void addEinbruchToGrundstueck(Grundstueck grundstueck, Einbruch einbruch) {
        Grundstueck betroffen = getGrundstueck(grundstueck.getStrasse(), grundstueck.getHausnummer());
        if (betroffen == null) {
            grundstuecke.append(grundstueck);
            betroffen = grundstueck;
        }
        betroffen.addEinbruch(einbruch);

        grundstuecke.toFirst();
        while (grundstuecke.hasAccess()) {
            Grundstueck current = grundstuecke.getContent();
            int abstand = current.getAbstand(betroffen);
            if (abstand <= 1000) {
                int wert = current.getGefaehrdungsindex() - abstand;
                if (einbruch.isAufgeklaert()) {
                    current.setGefaehrdungsindex(wert + 1000);
                } else {
                    current.setGefaehrdungsindex(wert + 2000);
                }
            }
            grundstuecke.next();
        }
    }

    public List<Grundstueck> getGrundstueckeByMinAnzahlEinbrueche(int minEinbrueche) {
        List<Grundstueck> grundstueckList = new List<>();

        grundstuecke.toFirst();
        while (grundstuecke.hasAccess()) {
            List<Einbruch> einbruchList = grundstuecke.getContent().getEinbrueche();
            einbruchList.toFirst();
            int anzahlEinbrueche = 0;
            while (einbruchList.hasAccess()) {
                if (anzahlEinbrueche == 8) {
                    grundstueckList.append(grundstuecke.getContent());
                    grundstuecke.next();
                    break;
                }
                anzahlEinbrueche++;
                einbruchList.next();
            }
        }

        return grundstueckList;
    }
}
