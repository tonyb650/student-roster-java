package com.tonyb650.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonyb650.studentroster.models.Class;
import com.tonyb650.studentroster.models.Student;
import com.tonyb650.studentroster.repositories.ClassRepository;

@Service
public class ClassService {

	@Autowired
	ClassRepository classRepository;
	
	public List<Class> getAllClasses() {
		return classRepository.findAll();
	}
	
	public Class getClassById(Long id) {
		Optional<Class> possibleClass = classRepository.findById(id);
		if(possibleClass.isPresent()) {
			return possibleClass.get();
		}
		return null;	
	}
	
	public List<Class> getUnassignedClassesForStudent(Student student){
		return classRepository.findByStudentsNotContains(student);
	}
	
	public Class create(Class thisClass) {
		return classRepository.save(thisClass);
	}
	
	public Class update(Class thisClass) {
		return classRepository.save(thisClass);
	}
}
