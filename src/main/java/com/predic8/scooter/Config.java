package com.predic8.scooter;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.*;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Config {

    @Bean
    @LoadBalanced
    WebClient.Builder builder() {
        return WebClient.builder();
    }

    @Bean
    public CommonsRequestLoggingFilter filter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeClientInfo(true);
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setIncludeHeaders(true);
        return filter;
    }
}
