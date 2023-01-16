package org.mitarbeiter;

import org.gps.Gps;

public class Fahrer
        extends Schichtarbeiter {

    private String fuehrerscheinKlasse;

    public Fahrer(String newName, int newId, double stundenSatz, String fuehrerscheinKlasse) throws IllegalArgumentException {
        super(newName, newId, stundenSatz);
        setFuehrerscheinKlasse(fuehrerscheinKlasse);
    }

    public Gps fahrenZu(Gps ziel) {
        return ziel;
    }

    public String getFuehrerscheinKlasse() {
        return fuehrerscheinKlasse;
    }

    public void setFuehrerscheinKlasse(String fuehrerscheinKlasse) {
        this.fuehrerscheinKlasse = fuehrerscheinKlasse;
    }
}
