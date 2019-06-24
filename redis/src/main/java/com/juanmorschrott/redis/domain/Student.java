package com.juanmorschrott.redis.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@RedisHash("Student")
public class Student implements Serializable {
    @Id
    private String id;
    @Indexed
    private String name;
    private String lastName;
    private Evaluation evaluation;
}
