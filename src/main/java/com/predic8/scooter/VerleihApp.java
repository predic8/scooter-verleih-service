package com.predic8.scooter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;

import java.time.LocalDate;

@SpringBootApplication
public class VerleihApp {

    public static void main(String[] args) {
        SpringApplication.run(VerleihApp.class, args);
    }

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.predic8.scooter"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class);
    }

    @Bean
    UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder()
                .build();
    }

}
