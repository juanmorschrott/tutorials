package com.juanmorschrott.redis;

import com.juanmorschrott.redis.domain.Evaluation;
import com.juanmorschrott.redis.domain.School;
import com.juanmorschrott.redis.domain.Student;
import com.juanmorschrott.redis.repository.SchoolRepository;
import com.juanmorschrott.redis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class RedisApplication implements ApplicationRunner {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SchoolRepository schoolRepository;

	public static void main(String[] args) {
		SpringApplication.run(RedisApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		studentRepository.deleteAll();

		Student s1 = new Student();
		s1.setName("Gabriel");
		Evaluation e1 = new Evaluation();
		e1.setImprove("Tiene muchas dificultades");
		s1.setEvaluation(e1);
		studentRepository.save(s1);

		Student s2 = new Student();
		s2.setName("Eric");
		Evaluation e2 = new Evaluation();
		e2.setImprove("No tiene interes por trabajar");
		s2.setEvaluation(e2);
		studentRepository.save(s2);

		Optional<Student> searchResult = studentRepository.findByName("Gabriel");

		System.out.println("---------");
		System.out.println("Student found by name:");
		System.out.println(searchResult.isPresent() ? ("  * " + searchResult.get().toString()) : "Student not found");
		System.out.println("---------");

		List<Student> students = studentRepository.findAll();

		System.out.println("Students:");
		for (Student s : students) {
			System.out.println("  * " + s.getName());
		}
		System.out.println("---------");


		System.out.println("List operations example:");
		School sc1 = new School();
		sc1.setName("San Ildefonso");
		schoolRepository.addSchool(sc1);

		School sc2 = new School();
		sc2.setName("La Porciuncula");
		schoolRepository.addSchool(sc2);

		List<School> schools = schoolRepository.findAll();
		for (School s : schools) {
			System.out.println("  * " + s.getName());
		}
		System.out.println("---------");

		schoolRepository.removeSchool(sc1);
		schoolRepository.removeSchool(sc2);
	}
}
