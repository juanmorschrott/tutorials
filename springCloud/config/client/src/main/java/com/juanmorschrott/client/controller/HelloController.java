package com.juanmorschrott.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@RestController
@RequestMapping("/")
public class HelloController {

    @Value("${custom.name}")
    String customName;

    @GetMapping
    public String hello() {
        return "Hello " + customName;
    }

}
