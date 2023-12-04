package com.tonyb650.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tonyb650.studentroster.models.Student;
import com.tonyb650.studentroster.models.Class;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	List<Student> findAll();
	List<Student> findByClasses(Class thisClass); // 'Solution' code didn't have this query
	
	// 'Solution' code used the following query which I didn't need, presumably because each "dorm" object already holds a list of Students related to that dorm
	List<Student> findByDormIdIs(Long dormId);
	
}
