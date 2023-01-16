package org.mitarbeiter;

public class Schichtarbeiter
        extends Mitarbeiter {

    private double stundenSatz;
    private int anzahlStunden;

    public Schichtarbeiter(String newName, int newId, double stundenSatz) throws IllegalArgumentException {
        super(newName, newId);
        setStundenSatz(stundenSatz);
    }

    @Override
    protected boolean validate(int id) {
        return (id >= 3000) && (id < 4000);
    }

    public int getAnzahlStunden() {
        return this.anzahlStunden;
    }

    public void setAnzahlStunden(int stunden) {
        if (stunden > 0) {
            this.anzahlStunden = stunden;
        }
    }

    public double getStundenSatz() {
        return stundenSatz;
    }

    public void setStundenSatz(double stundenSatz) throws IllegalArgumentException {
        if (stundenSatz >= 9.82) {
            this.stundenSatz = stundenSatz;
        } else throw new IllegalArgumentException("Stundensatz zu gering!");
    }

    public double einkommen() {
        return this.stundenSatz * this.anzahlStunden;
    }

    @Override
    public String toString() {
        return "Schichtarbeiter{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", stundenSatz=" + stundenSatz +
                ", anzahlStunden=" + anzahlStunden +
                ", einkommen=" + einkommen() +
                '}';
    }
}
