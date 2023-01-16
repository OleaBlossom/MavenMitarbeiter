package org.mitarbeiter;

import java.util.Comparator;

public abstract class Mitarbeiter
        implements Comparable<Mitarbeiter> {
    private int id;
    private String name;

    public Mitarbeiter(String newName, int newId) {
        boolean isValid = validate(newId);

        if (isValid) {
            setId(newId);
            setName(newName);
        } else {
            throw new IllegalArgumentException("please refer to the schema for creating a user id");
        }
    }

    protected boolean validate(int id) {
        return (id >= 1000) && (id <= 9999);
    }

    public String getName() {
        return name;
    }

    protected void setName(String newName) {
        name = newName;
    }

    @Override
    public int compareTo(Mitarbeiter m) {
        return getName().compareToIgnoreCase(m.getName());
    }

    public int getId() {
        return id;
    }

    protected void setId(int newId) {
        id = newId;
    }

    public abstract double einkommen();

    public int getAnzahlMitarbeiter() {
        return 1;
    }

    public static class MitarbeiterIncomeComparator implements Comparator<Mitarbeiter> {
        @Override
        public int compare(Mitarbeiter m1, Mitarbeiter m2) {
            double difference = m1.einkommen() - m2.einkommen();
            int result = -1;

            if (difference == 0) {
                result = 0;
            } else if (difference > 0) {
                result = 1;
            }

            return result;
        }
    }
}