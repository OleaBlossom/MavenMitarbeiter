package org.gps;

public class Gps {
    private double laengengrad;
    private double breitengrad;

    public Gps(double laengengrad, double breitengrad) {
        setLaengengrad(laengengrad);
        setBreitengrad(breitengrad);
    }

    public double getLaengengrad() {
        return laengengrad;
    }

    public void setLaengengrad(double laengengrad) {
        if (laengengrad >= 0 && laengengrad <= 360) {
            this.laengengrad = laengengrad;
        } else {
            throw new IllegalArgumentException("longitude must be between 0 and 360");
        }
    }

    public double getBreitengrad() {
        return breitengrad;
    }

    public void setBreitengrad(double breitengrad) {
        if (breitengrad >= -90 && breitengrad <= 90) {
            this.breitengrad = breitengrad;
        } else {
            throw new IllegalArgumentException("latitude must be between the south pole (-90) and north pole (90)");
        }
    }
}