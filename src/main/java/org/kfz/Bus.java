package org.kfz;


import org.gps.Gps;
import org.mitarbeiter.Fahrer;

import java.util.*;

public class Bus extends Ptf {
    public Bus(double tankGroesse, Gps aktuellePosition, int sitze) {
        super(tankGroesse, aktuellePosition, sitze);
    }

    public boolean einsteigenFahrer(Fahrer fahrer) {
        List<String> erlaubteKlassen = Arrays.asList(FS_BUS_MINI, FS_BUS_GROSS);

        boolean istErlaubt = erlaubteKlassen.contains(fahrer.getFuehrerscheinKlasse());

        if (istErlaubt) {
            istErlaubt = super.einsteigenFahrer(fahrer);
        }

        return istErlaubt;
    }
}
