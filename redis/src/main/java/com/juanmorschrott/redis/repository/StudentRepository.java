package com.juanmorschrott.redis.repository;

import com.juanmorschrott.redis.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
    Optional<Student> findByName(String name);
    List<Student> findAll();
}
