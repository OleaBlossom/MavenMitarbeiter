package org.mitarbeiter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MitarbeiterTest {

    @Test
    void validate() {

        Mitarbeiter m = new Mitarbeiter("Anonymous Mitarbeiter", 1000) {
            @Override
            public double einkommen() {
                return 0;
            }
        };

        assertTrue(m.validate(m.getId()));
    }

    @Test
    void name() {
        Mitarbeiter m = new Mitarbeiter("Anonymous Mitarbeiter", 1000) {
            @Override
            public double einkommen() {
                return 0;
            }
        };

        assertEquals("Anonymous Mitarbeiter", m.getName());
    }
}