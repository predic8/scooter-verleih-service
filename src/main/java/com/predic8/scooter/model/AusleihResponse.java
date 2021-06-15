package com.predic8.scooter.model;

public class AusleihResponse {

    String ergebnis;

    public AusleihResponse() {
    }

    public AusleihResponse(String ergebnis) {
        this.ergebnis = ergebnis;
    }

    public String getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(String ergebnis) {
        this.ergebnis = ergebnis;
    }
}
