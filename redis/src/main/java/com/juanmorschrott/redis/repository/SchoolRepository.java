package com.juanmorschrott.redis.repository;

import com.juanmorschrott.redis.domain.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchoolRepository {

    private static final String KEY = "schools";

    @Autowired
    private RedisTemplate<String, School> redisTemplate;

    public List<School> findAll() {
        return redisTemplate.opsForList().range(KEY, 0, 10);
    }

    public void addSchool(School school) {
        redisTemplate.opsForList().leftPush(KEY, school);
    }

    public void removeSchool(School school) {
        redisTemplate.opsForList().remove(KEY, 1, school);
    }

}
