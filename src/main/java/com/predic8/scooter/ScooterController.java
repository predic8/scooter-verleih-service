package com.predic8.scooter;

import com.predic8.scooter.model.AusleihResponse;
import com.predic8.scooter.model.ScooterBuchung;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;

@RestController
public class ScooterController {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    KafkaTemplate<String, String> template;

    @Autowired
    VerfuegbarkeitsService verfuegbarkeitsService;

    @PostMapping("/scooter/{id}/ausleihen")
    public ResponseEntity<AusleihResponse> ausleihen(@PathVariable String id, @RequestBody ScooterBuchung scooterBuchung) {
        log.info("Scooter mit ID: " + id + " soll verliehen werden an Benutzer mit ID: " + scooterBuchung.getBenutzer());
        if (!verfuegbarkeitsService.prueferVerfuegbarkeit(id).getBody().isVerfuegbar())
            return ResponseEntity.ok(new AusleihResponse("fehlgeschlagen"));
        template.send("scooter.buchung", id);
        return ResponseEntity.ok(new AusleihResponse("erfolgreich"));
    }

}
