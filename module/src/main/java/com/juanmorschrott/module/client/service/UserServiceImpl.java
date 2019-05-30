package com.juanmorschrott.module.client.service;

import com.juanmorschrott.module.client.configuration.ClientConfiguration;
import com.juanmorschrott.module.client.dto.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@Data
public class UserServiceImpl implements UserService {

    @Autowired
    public ClientConfiguration clientConfiguration;

    @Override
    public User getUser(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://" + clientConfiguration.getUrl() + ":" + clientConfiguration.getPort();
        ResponseEntity<User> response = restTemplate.getForEntity(resourceUrl + "/1", User.class);

        return response.getBody();
    }

}
