package com.predic8.scooter.model;

public class Ausleihe {

    private String benutzer;

    public Ausleihe() {
    }

    public Ausleihe(String benutzer) {
        this.benutzer = benutzer;
    }

    public String getBenutzer() {
        return benutzer;
    }

    public void setBenutzer(String benutzer) {
        this.benutzer = benutzer;
    }
}
