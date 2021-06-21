package com.predic8.scooter;

import com.predic8.scooter.model.*;
import org.slf4j.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.MethodHandles;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class AusleihAPI {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @PostMapping("/scooter/{id}/ausleihen")
    public ResponseEntity<AusleihResponse> ausleihen(@PathVariable String id, @RequestBody Ausleihe ausleihe) {

        log.info("Scooter: " + id + " soll verliehen werden an Benutzer: " + ausleihe.getBenutzer());

        String fahrtId = UUID.randomUUID().toString();

        return ok(new AusleihResponse("erfolg", fahrtId));
    }

}
