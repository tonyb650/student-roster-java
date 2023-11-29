package com.tonyb650.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonyb650.studentroster.models.Student;
import com.tonyb650.studentroster.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	public List<Student> allStudents() {
		return studentRepository.findAll();
	}
	
	public Student findStudentById(Long id) {
		Optional<Student> possibleStudent = studentRepository.findById(id);
		if(possibleStudent.isPresent()) {
			return possibleStudent.get();
		}
		return null;
	}
	
	public Student create(Student student) {
		return studentRepository.save(student);
	}
	
	public Student update(Student student) {
		return studentRepository.save(student);
	}
	
	public void delete(Long id) {
		studentRepository.deleteById(id);
	}
}
