package com.predic8.scooter;

import com.predic8.scooter.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.retry.annotation.*;
import org.springframework.stereotype.Service;

import static org.springframework.http.ResponseEntity.ok;

@Service
public class AusleihService {

    @Autowired
    KafkaTemplate<String, String> kafka;

    @Autowired
    VerfuegbarkeitsClient verfuegbarkeitsService;

    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 10_000),exclude = { RuntimeException.class})
    public void ausleihen(String scooter, Ausleihe ausleihe) {
        if (!verfuegbarkeitsService.pruefeVerfuegbarkeit(scooter).getBody().isVerfuegbar())
            throw new RuntimeException("Kein Scooter verfügbar");

        kafka.send("scooter.ausleihe", scooter);
    }
}
