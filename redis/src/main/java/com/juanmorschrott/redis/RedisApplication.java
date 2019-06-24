package com.juanmorschrott.redis;

import com.juanmorschrott.redis.domain.Evaluation;
import com.juanmorschrott.redis.domain.Student;
import com.juanmorschrott.redis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class RedisApplication implements ApplicationRunner {

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		studentRepository.deleteAll();

		Student s1 = new Student();
		s1.setId("1");
		s1.setName("Gabriel");
		Evaluation e1 = new Evaluation();
		e1.setImprove("Tiene muchas dificultades");
		s1.setEvaluation(e1);
		studentRepository.save(s1);

		Student s2 = new Student();
		s2.setId("2");
		s2.setName("Eric");
		Evaluation e2 = new Evaluation();
		e2.setImprove("No tiene interes por trabajar");
		s2.setEvaluation(e2);
		studentRepository.save(s2);

		Optional<Student> searchResult = studentRepository.findById("1");

		System.out.println(searchResult.isPresent() ? searchResult : "Student not found");
	}
}
