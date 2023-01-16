package org.verwaltung;


import org.mitarbeiter.Mitarbeiter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class AbteilungenListeSpeicher {
    ArrayList<Abteilung> alleAbteilungen;

    public AbteilungenListeSpeicher(ArrayList<Abteilung> abteilungen) {
        this.alleAbteilungen = abteilungen;

        try {
            abteilungenCsvSpeichern();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void abteilungenCsvSpeichern() throws FileNotFoundException {
        List<String> dataLines = new ArrayList<>();
        double einkommenInsgesamt = 0;
        for (Abteilung a :
                alleAbteilungen) {

            double einkommenProAbteilung = 0;
            dataLines.add("Abteilung: " + a.getName());

            for (Mitarbeiter m :
                    a.getAlleMitarbeiter()) {

                dataLines.add(m.getId() + ", " +
                        m.getName() + ", " +
                        m.einkommen());

                einkommenProAbteilung += m.einkommen();
                einkommenInsgesamt += m.einkommen();
            }

            dataLines.add("Einkommen: " + einkommenProAbteilung);
        }

        dataLines.add("Einkommen insgesamt: " + einkommenInsgesamt);

        File csvOutputFile = new File("mitarbeiterInfos.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.forEach(pw::println);
        }

    }
}
