package com.predic8.scooter.model;

public class AusleihResponse {

    String ergebnis;
    String fahrtId;

    public AusleihResponse() {
    }

    public AusleihResponse(String ergebnis) {
        this.ergebnis = ergebnis;
    }

    public AusleihResponse(String ergebnis, String fahrtId) {
        this.ergebnis = ergebnis;
        this.fahrtId = fahrtId;
    }

    public String getErgebnis() {
        return ergebnis;
    }

    public void setErgebnis(String ergebnis) {
        this.ergebnis = ergebnis;
    }

    public String getFahrtId() {
        return fahrtId;
    }

    public void setFahrtId(String fahrtId) {
        this.fahrtId = fahrtId;
    }
}
