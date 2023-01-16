package org.kfz;


import org.gps.Gps;
import org.mitarbeiter.Fahrer;

import java.util.Arrays;
import java.util.List;

// Lastkraftwagen
public class Lkw extends Kfz {

    private double ladeflaeche;

    private double ladung = 0;

    public Lkw(double tankGroesse, Gps aktuellePosition, double ladeflaeche) {
        super(tankGroesse, aktuellePosition);
        setLadeflaeche(ladeflaeche);
    }

    public void beladen(double menge) {
        double newLadung = ladung + menge;

        if (newLadung > ladeflaeche) {
            throw new IllegalArgumentException("you can't load more items than there is place to store it!");
        } else {
            ladung = newLadung;
        }
    }

    public void entladen(double menge) {
        double newLadung = ladung - menge;

        if (newLadung < 0) {
            throw new IllegalArgumentException("you can't unload more items than exist!");
        } else {
            setLadung(newLadung);
        }
    }

    public boolean einsteigenFahrer(Fahrer fahrer) {
        List<String> erlaubteKlassen = Arrays.asList(FS_KRAFTFAHRZEUG_GROSS, FS_BUS_MINI, FS_BUS_GROSS);

        boolean istErlaubt = erlaubteKlassen.contains(fahrer.getFuehrerscheinKlasse());

        if (istErlaubt) {
            istErlaubt = super.einsteigenFahrer(fahrer);
        }

        return istErlaubt;
    }

    @Override
    public double auslastungBerechnen() {
        return ladung / ladeflaeche;
    }

    public double getLadeflaeche() {
        return this.ladeflaeche;
    }

    public void setLadeflaeche(double ladeflaeche) {
        this.ladeflaeche = ladeflaeche;
    }

    public double getLadung() {
        return ladung;
    }

    public void setLadung(double ladung) {
        this.ladung = ladung;
    }
}
