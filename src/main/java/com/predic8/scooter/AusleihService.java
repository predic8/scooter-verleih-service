package com.predic8.scooter;

import com.predic8.scooter.model.*;
import io.swagger.annotations.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.retry.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.ResponseEntity.ok;

@Service
public class AusleihService {


    KafkaTemplate<String, String> kafka;

    WebClient client;

    public AusleihService(KafkaTemplate<String, String> kafka, WebClient.Builder webClientBuilder) {
        this.kafka = kafka;

        client = webClientBuilder.baseUrl("http://verfuegbarkeits-service:8081").build();

    }

    @Retryable(maxAttempts = 5, backoff = @Backoff(delay = 2_000),exclude = { NichtVerfuegbarException.class})
    public void ausleihen(String scooter, Ausleihe ausleihe) throws NichtVerfuegbarException {

        Mono<Verfuegbarkeit> verfuegbarkeit = client.get().uri("/scooter/{id}/verfuegbarkeit", scooter).retrieve().bodyToMono(Verfuegbarkeit.class);

        Verfuegbarkeit v = verfuegbarkeit.block();

        if (!v.isVerfuegbar())
            throw new NichtVerfuegbarException("Pech gehabt!");
        
        kafka.send("scooter.ausleihe", scooter);
    }
}
