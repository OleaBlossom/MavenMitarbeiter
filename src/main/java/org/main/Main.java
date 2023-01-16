package org.main;

import org.mitarbeiter.*;
import org.verwaltung.*;

import java.util.ArrayList;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        testMitarbeiter();
    }

    public static void testMitarbeiter() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Mitarbeiter Section");
        System.out.println("---------------------------------------------------------------");
        System.out.println("\n");
        Bueroarbeiter firstEmployee = new Bueroarbeiter("First Employee", 5000, 25000);
        System.out.println(firstEmployee);

        Schichtarbeiter shiftWorker = new Schichtarbeiter("Shift Worker", 3005, 25);
        shiftWorker.setAnzahlStunden(20);
        System.out.println(shiftWorker);

        Bueroarbeiter officeWorker = new Bueroarbeiter("Office Worker", 5001, 8540);
        System.out.println(officeWorker);

        Manager managerPerson = new Manager("Manager Person", 5009, 100000, 12.5);
        System.out.println(managerPerson);

        ArrayList<Mitarbeiter> listOfMitarbeiter = new ArrayList<>();
        listOfMitarbeiter.add(firstEmployee);
        listOfMitarbeiter.add(shiftWorker);
        listOfMitarbeiter.add(officeWorker);
        listOfMitarbeiter.add(managerPerson);

        System.out.println(listOfMitarbeiter);

        Mitarbeiter.MitarbeiterIncomeComparator comparator = new Mitarbeiter.MitarbeiterIncomeComparator();

        sort(listOfMitarbeiter);
        System.out.println("---------------------------------------------------------------");
        System.out.println("sorting by name ...");
        System.out.println("---------------------------------------------------------------");
        System.out.println(listOfMitarbeiter);

        listOfMitarbeiter.sort(comparator);
        System.out.println("---------------------------------------------------------------");
        System.out.println("sorting by income ...");
        System.out.println("---------------------------------------------------------------");
        System.out.println(listOfMitarbeiter);

        System.out.println("\n\n");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Abteilung Section");
        System.out.println("---------------------------------------------------------------");
        System.out.println("\n");

        Abteilung abteilung1 = new Abteilung("first department", managerPerson);
        System.out.println(abteilung1.getLeiter());
        System.out.println(abteilung1.getAlleMitarbeiter());
        abteilung1.addMitarbeiter(firstEmployee);
        abteilung1.addMitarbeiter(shiftWorker);
        abteilung1.addMitarbeiter(officeWorker);
        System.out.println(abteilung1);
        abteilung1.removeMitarbeiter(shiftWorker);
        System.out.println(managerPerson.getAbteilung());

        System.out.println("---------------------------------------------------------------");
        System.out.println("Abteilung Composite Section");
        System.out.println("---------------------------------------------------------------");

        Manager manager2 = new Manager("Another Manager", 5010, 100000, 10.5);
        Abteilung abteilung2 = new Abteilung("department two", manager2);
        abteilung2.addMitarbeiter(shiftWorker);

        ArrayList<Abteilung> listOfDepts = new ArrayList<>();
        listOfDepts.add(abteilung1);
        listOfDepts.add(abteilung2);

        Unternehmensbereich unternehmensbereich = new Unternehmensbereich("big mama", new Manager("big mama manager", 5011, 60000, 20), listOfDepts);
        System.out.println(unternehmensbereich);

        AbteilungenListeSpeicher speicher = new AbteilungenListeSpeicher(listOfDepts);
    }
}