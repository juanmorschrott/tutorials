package com.juanmorschrott.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/instances")
    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("client");
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        return null;
    }

}
