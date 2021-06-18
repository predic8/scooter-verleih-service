package com.predic8.scooter.model;

import java.time.LocalDateTime;

public class VerleihDTO {

    String scooterId;
    String userId;
    LocalDateTime verleihBeginn;

    public VerleihDTO() {
    }

    public VerleihDTO(String scooter, Ausleihe ausleihe) {
        this.scooterId = scooter;
        this.userId = ausleihe.getBenutzer();
        verleihBeginn = LocalDateTime.now();
    }

    public VerleihDTO(String scooterId, String userId, LocalDateTime verleihBeginn) {
        this.scooterId = scooterId;
        this.userId = userId;
        this.verleihBeginn = verleihBeginn;
    }

    public String getScooterId() {
        return scooterId;
    }

    public void setScooterId(String scooterId) {
        this.scooterId = scooterId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getVerleihBeginn() {
        return verleihBeginn;
    }

    public void setVerleihBeginn(LocalDateTime verleihBeginn) {
        this.verleihBeginn = verleihBeginn;
    }
}
