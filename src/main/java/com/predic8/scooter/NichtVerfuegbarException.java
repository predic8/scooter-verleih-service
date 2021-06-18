package com.predic8.scooter;

public class NichtVerfuegbarException extends Exception {

    public NichtVerfuegbarException(String message) {
        super(message);
    }
}
