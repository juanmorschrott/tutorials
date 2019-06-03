package com.juanmorschrott.module.client.service;

import com.juanmorschrott.module.client.dto.Foo;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface FooService {
    Foo getFoo(Integer id) throws IOException;
}
