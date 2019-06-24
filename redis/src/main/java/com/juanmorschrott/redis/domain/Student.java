package com.juanmorschrott.redis.domain;

import lombok.Data;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@RedisHash("Student")
public class Student implements Serializable {
    private String id;
    private String name;
    private String lastName;
    private Evaluation evaluation;
}
