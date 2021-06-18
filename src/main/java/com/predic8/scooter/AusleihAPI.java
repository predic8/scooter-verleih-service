package com.predic8.scooter;

import com.predic8.scooter.model.AusleihResponse;
import com.predic8.scooter.model.Ausleihe;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandles;
import java.util.UUID;

import static org.springframework.http.ResponseEntity.ok;

@Api(value = "Ausleih API", tags = "Scooter")
@RestController
public class AusleihAPI {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    MeterRegistry meterRegistry;

    @Autowired
    AusleihService ausleihService;

    @PostMapping("/scooter/{id}/ausleihen")
    public ResponseEntity<AusleihResponse> ausleihen(@PathVariable String id, @RequestBody Ausleihe ausleihe) {

        log.info("Scooter mit ID: " + id + " soll verliehen werden an Benutzer mit ID: " + ausleihe.getBenutzer());

        meterRegistry.counter("ausleihe").increment();

        String fahrtId = UUID.randomUUID().toString();
        try {
            ausleihService.ausleihen(id, ausleihe, fahrtId);
        } catch (Exception e) {
            log.warn("Exception:  " + e);
            meterRegistry.counter("ausleihe.fehler").increment();
            return ok(new AusleihResponse("fehler",fahrtId));
        }

        meterRegistry.counter("ausleihe.erfolg").increment();
        return ok(new AusleihResponse("erfolg", fahrtId));
    }

}
