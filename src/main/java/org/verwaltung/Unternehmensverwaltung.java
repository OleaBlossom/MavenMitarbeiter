package org.verwaltung;


import org.kfz.Kfz;
import org.mitarbeiter.Mitarbeiter;
import org.mitarbeiter.Schichtarbeiter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class Unternehmensverwaltung {

    private ArrayList<Kfz> fuhrpark;
    private ArrayList<Mitarbeiter> personalliste;
    private LinkedList<Schichtarbeiter> personallisteSchichtarbeiter;
    private TreeSet<Abteilung> abteilungen;

    public Unternehmensverwaltung(ArrayList<Kfz> fuhrpark, ArrayList<Mitarbeiter> personalliste, LinkedList<Schichtarbeiter> personallisteSchichtarbeiter, TreeSet<Abteilung> abteilungen) {
        setFuhrpark(fuhrpark);
        setPersonalliste(personalliste);
        setPersonallisteSchichtarbeiter(personallisteSchichtarbeiter);
        setAbteilungen(abteilungen);
    }


    public ArrayList<Kfz> getFuhrpark() {
        return fuhrpark;
    }

    public void setFuhrpark(ArrayList<Kfz> fuhrpark) {
        this.fuhrpark = fuhrpark;
    }

    public void addKfz(Kfz kfz) {
        this.fuhrpark.add(kfz);
    }

    public void removeKfz(Kfz kfz) {
        this.fuhrpark.remove(kfz);
    }

    public ArrayList<Mitarbeiter> getPersonalliste() {
        return personalliste;
    }

    public void setPersonalliste(ArrayList<Mitarbeiter> personalliste) {
        this.personalliste = personalliste;
    }

    public void addMitarbeiter(Mitarbeiter mitarbeiter) {
        this.personalliste.add(mitarbeiter);
    }

    public void removeMitarbeiter(Mitarbeiter mitarbeiter) {
        this.personalliste.remove(mitarbeiter);
    }

    public LinkedList<Schichtarbeiter> getPersonallisteSchichtarbeiter() {
        return personallisteSchichtarbeiter;
    }

    public void setPersonallisteSchichtarbeiter(LinkedList<Schichtarbeiter> personallisteSchichtarbeiter) {
        this.personallisteSchichtarbeiter = personallisteSchichtarbeiter;
    }

    public void addMitarbeiter(Schichtarbeiter mitarbeiter) {
        this.personalliste.add(mitarbeiter);
        this.personallisteSchichtarbeiter.add(mitarbeiter);
    }

    public void removeMitarbeiter(Schichtarbeiter mitarbeiter) {
        this.personalliste.remove(mitarbeiter);
        this.personallisteSchichtarbeiter.remove(mitarbeiter);
    }

    public void addWorkingHours(int numberOfHours) {
        for (Schichtarbeiter schichtarbeiter : personallisteSchichtarbeiter) {
            schichtarbeiter.setAnzahlStunden((schichtarbeiter.getAnzahlStunden() + numberOfHours));
        }
    }

    public TreeSet<Abteilung> getAbteilungen() {
        return abteilungen;
    }

    public void setAbteilungen(TreeSet<Abteilung> abteilungen) {
        this.abteilungen = abteilungen;
    }

    public void addAbteilung(Abteilung abteilung) {
        this.abteilungen.add(abteilung);
    }

    public void removeAbteilung(Abteilung abteilung) {
        this.abteilungen.remove(abteilung);
    }

}
