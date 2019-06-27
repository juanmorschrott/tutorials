package com.juanmorschrott.redis.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Data
@ToString
public class School implements Serializable {
    @Id
    private String id;
    @Indexed
    private String name;
}
