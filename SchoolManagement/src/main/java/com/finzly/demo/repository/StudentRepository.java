package com.finzly.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.finzly.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	  
	List<Student> findByName(String name);

	List<Student> findByCity(String city);

	List<Student> findByStandard(String standard);

	List<Student> findBySchool(String school);

	List<Student> findByPhoneno(String phoneno);

	@Query("SELECT student FROM Student student WHERE student.marks > :mark")
	List<Student> findAllStudentMarks(int mark);

	@Modifying
	@Transactional
	@Query("UPDATE Student s SET s.city = :city WHERE s.id = :id")
	void updateCityById(long id, String city);

	
	@Modifying
	@Transactional
	@Query("UPDATE Student s SET s.city = :city, s.name = :name,  s.phoneno = :phoneno, s.standard = :standard WHERE s.id = :id")
	void updateStudentById(long id, String city, String name, String phoneno, String standard);

}
