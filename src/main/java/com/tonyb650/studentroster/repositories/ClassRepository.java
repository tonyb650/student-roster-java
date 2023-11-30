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
}
