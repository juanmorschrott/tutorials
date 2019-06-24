package com.juanmorschrott.redis.repository;

import com.juanmorschrott.redis.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
    Student findByName(String name);
}
