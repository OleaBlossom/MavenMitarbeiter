package org.verwaltung;


import org.mitarbeiter.Manager;
import org.mitarbeiter.Mitarbeiter;

import java.util.ArrayList;
import java.util.List;

public class Abteilung implements AbteilungCompositeInterface {
    private String name;
    private Manager leiter;
    private final ArrayList<Mitarbeiter> alleMitarbeiter;

    public Abteilung(String name, Manager leiter) {
        setName(name);
        setLeiter(leiter);
        alleMitarbeiter = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getLeiter() {
        return this.leiter;
    }

    public void setLeiter(Manager manager) {
        this.leiter = manager;
        manager.setAbteilung(this);
    }

    public Manager changeLeiter(Manager newManager) {
        Manager oldManager = this.leiter;
        setLeiter(newManager);
        oldManager.setAbteilung(null);
        return oldManager;
    }

    public List<Mitarbeiter> getAlleMitarbeiter() {
        return this.alleMitarbeiter;
    }

    public void addMitarbeiter(Mitarbeiter employee) {
        this.alleMitarbeiter.add(employee);
    }

    public void removeMitarbeiter(Mitarbeiter employee) {
        this.alleMitarbeiter.remove(employee);
    }

    public String gehaltsliste() {
        StringBuilder output = new StringBuilder();
        Manager manager = getLeiter();
        output.append("Leiter: \n");
        output.append(manager.getName()).append(", ").append(manager.einkommen()).append("\n");
        output.append("Mitarbeiter: \n");
        for (Mitarbeiter mitarbeiter : getAlleMitarbeiter()) {
            output.append(mitarbeiter.getName()).append(", ").append(mitarbeiter.einkommen()).append("\n");
        }

        return output.toString();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Abteilung:");
        output.append(" ");
        output.append(getName());
        output.append(" (").append(getTotalNumberEmployees()).append(" Mitarbeiter insgesamt)");
        output.append("\n");
        output.append("Leiter:");
        output.append(" ");
        output.append(getLeiter().getName());
        output.append("\n");
        output.append("Mitarbeiter:");
        output.append("\n");
        for (Mitarbeiter mitarbeiter : getAlleMitarbeiter()) {
            output.append(mitarbeiter.getName());
            output.append("\n");
        }

        return output.toString();
    }

    @Override
    public int getTotalNumberEmployees() {
        return alleMitarbeiter.size() + 1;
    }
}
