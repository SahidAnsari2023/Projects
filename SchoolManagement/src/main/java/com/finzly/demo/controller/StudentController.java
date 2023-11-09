package com.finzly.demo.controller;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.finzly.demo.entity.Student;
import com.finzly.demo.service.StudentService;


@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/getall")
	public List<Student> getAllFromDatabaseJPA() {
		return studentService.getAllFromDatabaseJPA();
	}
	
	@PostMapping("/add")
	public String setStudentNameJPA(@RequestBody Student student) {
		return studentService.setStudentNameJPA(student);
	}
	
	@GetMapping("/getbyname/{name}")
	public List<Student> getAllByName(@PathVariable String name){
		return studentService.getAllByName(name);
	}
	
	@GetMapping("/getbycity/{city}")
	public List<Student> getAllByCity(@PathVariable String city) {
		return studentService.getAllByCity(city);
	}
	
	@GetMapping("/getbystandard/{standard}")
	public List<Student> getAllByStandard(@PathVariable String standard) {
		return studentService.getAllByStandard(standard);
	}
	
	@GetMapping("/getbyschool/{school}")
	public List<Student> getAllBySchool(@PathVariable String school) {
		return studentService.getAllBySchool(school);
	}
	
	@GetMapping("/getbyphoneno/{phoneno}")
	public List<Student> getAllByPhoneno(@PathVariable String phoneno) {
		return studentService.getAllByPhoneno(phoneno);
	}
	
	@GetMapping("/getstudentifmarkgt/{mark}")
	public List<Student> getAllStudentMarks(@PathVariable("mark") int mark){
		return studentService.getAllStudentMarks(mark);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateCityById(@PathVariable long id, @RequestParam String city) {		
			return studentService.updateCityById(id,city);
	}
	
	@PutMapping("/updatestudent/{id}")
	public ResponseEntity<String> updateStudentById(@PathVariable long id,
			@RequestParam String city,
			@RequestParam String name,
			@RequestParam String phoneno,
			@RequestParam String standard) {		
			return studentService.updateStudentById(id,city,name,phoneno,standard);
	}
	
}
