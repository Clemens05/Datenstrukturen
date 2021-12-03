package com.clemax.practices.vokabeltrainer;

import com.clemax.List;
import jdk.jfr.ContentType;

import java.util.Random;

public class Vokabeltrainer {
    private Sprache language1;
    private Sprache language2;
    private List<Vokabel> vokabelList;

    public Vokabeltrainer(Sprache language1, Sprache language2) {
        this.language1 = language1;
        this.language2 = language2;
        this.vokabelList = new List<>();
    }

    public Sprache getLanguage1() {
        return language1;
    }

    public Sprache getLanguage2() {
        return language2;
    }

    /**
     * @param word Das zu übersetzende Wort
     * @param language Die Sprache von der das zu übersetzende Wort kommt (Möglich: de, en)
     * @return Das übersetzte Wort. Wenn es keine Übersetzung gibt: null
     */
    public String translate(String word, String language) {
        // Liste auf word untersuche und das andere Wort zurückgeben
        return null;
    }

    public void insertSorted(Vokabel vokabel) {
        vokabelList.toFirst();

        while (vokabelList.hasAccess() && vokabelList.getContent().getWord1().compareTo(vokabel.getWord1()) < 0) {
            vokabelList.next();
        }

        if (vokabelList.hasAccess()) {
            vokabelList.insert(vokabel);
        } else {
            vokabelList.next();
        }
    }

    /**
     * @param language Die Sprache in der das erste Wort sein soll (Möglich: de, en)
     * @return Eine zufällige Vokabel
     */
    public Vokabel getRandomVokabel(String language) {
        // muss überarbeitet werden
        int randomint = new Random().nextInt(5);

        List<Vokabel> temp = vokabelList;
        temp.toFirst();

        for (int i = 0; i < randomint; i++) {
            temp.next();
        }

        return new Vokabel(
            (language.equals(language1.getShortname()) ? temp.getContent().getWord1() : temp.getContent().getWord2()),
            (language.equals(language1.getShortname()) ? temp.getContent().getWord2() : temp.getContent().getWord1()),
            temp.getContent().getId()
        );
    }

    public void sortAlphabetical() {

    }

    public void removeCurrentVokabel() {
        vokabelList.remove();
    }

    public void removeVokabelById(int id) {
        vokabelList.toFirst();
        while (vokabelList.getContent().getId() != id) {
            vokabelList.next();
        }

        this.removeCurrentVokabel();
    }

    public boolean isEmpty() {
        return vokabelList.isEmpty();
    }

    public Vokabel getCurrentVokabel() {
        return vokabelList.getContent();
    }

    public void setToFirst() {
        vokabelList.toFirst();
    }

    public void setToLast() {
        vokabelList.toLast();
    }

    public void setToNext() {
        vokabelList.next();
    }

    public void addVokabel(String word1, String word2) {
        Random r = new Random();
        int id = r.nextInt(100000);
        vokabelList.append(new Vokabel(word1, word2, id));
    }

    public void deleteCurrentVokabel() {
        vokabelList.remove();
    }

    public void editVokabelById(String word1, String word2, int id) {
        vokabelList.toFirst();
        while (vokabelList.getContent().getId() != id) {
            vokabelList.next();
        }

        this.editCurrentVokabel(word1, word2);
    }

    public void editCurrentVokabel(String word1, String word2) {
        vokabelList.setContent(new Vokabel(word1, word2, vokabelList.getContent().getId()));
    }
}
