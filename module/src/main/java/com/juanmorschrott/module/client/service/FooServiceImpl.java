package com.juanmorschrott.module.client.service;

import com.juanmorschrott.module.client.configuration.ClientConfiguration;
import com.juanmorschrott.module.client.dto.Foo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Data
public class FooServiceImpl implements FooService {

    @Autowired
    public ClientConfiguration clientConfiguration;

    @Override
    public Foo getFoo(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://" + clientConfiguration.getUrl() + ":" + clientConfiguration.getPort();
        ResponseEntity<Foo> response = restTemplate.getForEntity(resourceUrl + "/1", Foo.class);

        return response.getBody();
    }

}
