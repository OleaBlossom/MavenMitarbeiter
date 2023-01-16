package org.verwaltung;

import org.mitarbeiter.Manager;

import java.util.ArrayList;

public class Unternehmensbereich extends Abteilung implements AbteilungCompositeInterface {
    private final ArrayList<Abteilung> abteilungen;

    public Unternehmensbereich(String name, Manager manager, ArrayList<Abteilung> abteilungen) {
        super(name, manager);
        this.abteilungen = abteilungen;
    }

    @Override
    public int getTotalNumberEmployees() {
        int total = getAlleMitarbeiter().size() + 1;
        for (Abteilung abteilung :
                abteilungen) {
            total += abteilung.getTotalNumberEmployees();
        }

        return total;
    }

    public void addAbteilung(Abteilung abteilung) {
        this.abteilungen.add(abteilung);
    }

    public void removeAbteilung(Abteilung abteilung) {
        this.abteilungen.remove(abteilung);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (Abteilung tochter :
                abteilungen) {
            output.append(tochter.toString());
        }

        return output.toString();
    }
}
