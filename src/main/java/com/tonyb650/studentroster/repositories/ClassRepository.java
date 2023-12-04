package com.tonyb650.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tonyb650.studentroster.models.Class;
import com.tonyb650.studentroster.models.Student;

@Repository
public interface ClassRepository extends CrudRepository<Class, Long> {
	List<Class> findAll();
    List<Class> findByStudentsNotContains(Student student);
    
    // Didn't actually use the following query because this list is essentially contained within the "Student" object already
    // Also, in the solution files, it shows 'findAllByStudents' vs. 'findByStudents'. I'm not sure if there is a difference. It seems that either would work.
    List<Class> findByStudents(Student student); 
}
