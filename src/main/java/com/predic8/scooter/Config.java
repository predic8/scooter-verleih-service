package com.predic8.scooter;

import org.springframework.context.annotation.*;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class Config {

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
