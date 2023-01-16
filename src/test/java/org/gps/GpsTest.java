package org.gps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GpsTest {
    @Test
    void laengengrad() {
        Gps Instance = new Gps(12.876, 15.523);
        Instance.setLaengengrad(99.99999999999999);
        assertEquals(99.99999999999999, Instance.getLaengengrad());
        Instance.setLaengengrad(0);
        assertEquals(0, Instance.getLaengengrad());
        Instance.setLaengengrad(360);
        assertEquals(360, Instance.getLaengengrad());

        assertThrows(IllegalArgumentException.class, () -> {
            Instance.setLaengengrad(10000);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Instance.setLaengengrad(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Instance.setLaengengrad(360.0001);
        });
    }

    @Test
    void breitengrad() {
        Gps Instance = new Gps(12.876, 15.523);
        Instance.setBreitengrad(55.555);
        assertEquals(55.555, Instance.getBreitengrad());
        Instance.setBreitengrad(-90);
        assertEquals(-90, Instance.getBreitengrad());
        Instance.setBreitengrad(90);
        assertEquals(90, Instance.getBreitengrad());

        assertThrows(IllegalArgumentException.class, () -> {
            Instance.setBreitengrad(-91);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Instance.setBreitengrad(90.0001);
        });
    }
}