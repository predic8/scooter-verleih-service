package com.predic8.scooter.model;

public class ScooterBuchung {

    private String benutzer;

    public ScooterBuchung() {
    }

    public ScooterBuchung(String benutzer) {
        this.benutzer = benutzer;
    }

    public String getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(String benutzer) {
        this.benutzer = benutzer;
    }
}
