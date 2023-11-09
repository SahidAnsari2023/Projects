package com.finzly.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.finzly.demo.entity.Student;
import com.finzly.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getAllFromDatabaseJPA() {
		return studentRepository.findAll();
	}

	public String setStudentNameJPA(Student student) {
		try {
			studentRepository.save(student);
			return "Student Saved";
		} catch (Exception e) {
			return "Some Error, Not Saved" + e;
		}
	}

	public List<Student> getAllByCity(String city) {
		return studentRepository.findByCity(city);
	}

	public List<Student> getAllByStandard(String standard) {
		return studentRepository.findByStandard(standard);
	}

	public List<Student> getAllBySchool(String school) {
		return studentRepository.findBySchool(school);
	}

	public List<Student> getAllByPhoneno(String phoneno) {
		return studentRepository.findByPhoneno(phoneno);
	}

	public List<Student> getAllByName(String name) {
		return studentRepository.findByName(name);
	}

	public List<Student> getAllStudentMarks(int mark) {
		return studentRepository.findAllStudentMarks(mark);
	}

	public ResponseEntity<String> updateCityById(long id, String city){
		Optional<Student> s = studentRepository.findById(id);
		if(s.isPresent()) {
			studentRepository.updateCityById(id, city);
            return ResponseEntity.status(HttpStatus.OK).body("City Updated");
		}
		else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with ID: " + id);
		}
	}

	public ResponseEntity<String> updateStudentById(long id, String city, String name, String phoneno, String standard) {
		Optional<Student> s = studentRepository.findById(id);
		if(s.isPresent()) {
			studentRepository.updateStudentById(id,city,name,phoneno,standard);
            return ResponseEntity.status(HttpStatus.OK).body("Student Updated");
		}
		else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found with ID: " + id);
		}
	}

}
