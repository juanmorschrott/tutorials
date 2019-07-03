package com.juanmorschrott.frontend.controller;

import com.juanmorschrott.frontend.model.Hotel;
import io.opentracing.Tracer;
import io.opentracing.contrib.spring.web.client.TracingRestTemplateInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Controller
public class FrontendController {

    @Autowired
    private Tracer tracer;

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(new TracingRestTemplateInterceptor(tracer)));

        return restTemplate;
    }

    @GetMapping("/")
    public ResponseEntity<List<Hotel>> index() {
        final String URL = "http://localhost:8081/api/v1/hotels";

        ResponseEntity<List<Hotel>> response = restTemplate().exchange(
                URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Hotel>>(){});

        return response;
    }

}
