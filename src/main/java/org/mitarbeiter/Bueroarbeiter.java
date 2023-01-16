package org.mitarbeiter;

public class Bueroarbeiter
        extends Mitarbeiter {

    private double festgehalt;

    public Bueroarbeiter(String newName, int newId, double festgehalt) throws IllegalArgumentException {
        super(newName, newId);
        setFestgehalt(festgehalt);
    }


    @Override
    protected boolean validate(int id) {
        return (id >= 5000) && (id < 6000);
    }

    public double einkommen() {
        return getFestgehalt();
    }

    public double getFestgehalt() {
        return this.festgehalt;
    }

    public void setFestgehalt(double amount) throws IllegalArgumentException {
        if (festgehalt < 300) {
            this.festgehalt = amount;
        } else throw new IllegalArgumentException("Gehalt zu gering");
    }

    @Override
    public String toString() {
        return "Bueroarbeiter{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", festgehalt=" + festgehalt +
                ", einkommen=" + einkommen() +
                '}';
    }
}
