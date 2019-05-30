package com.juanmorschrott.module.client.service;

import com.juanmorschrott.module.client.dto.User;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface UserService {
    User getUser(Integer id) throws IOException;
}
