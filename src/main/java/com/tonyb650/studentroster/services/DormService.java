package com.tonyb650.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tonyb650.studentroster.models.Dorm;
import com.tonyb650.studentroster.repositories.DormRepository;

@Service
public class DormService {

	@Autowired
	DormRepository dormRepository;
	
	public List<Dorm> getAllDorms(){
		return dormRepository.findAll();
	}
	
	public Dorm findDormById(Long id) {
		Optional<Dorm> possibleDorm = dormRepository.findById(id);
		if(possibleDorm.isPresent()) {
			return possibleDorm.get();
		}
		return null;
	}
	
	public Dorm create(Dorm dorm) {
		return dormRepository.save(dorm);
	}
	
	public Dorm udpate(Dorm dorm) {
		return dormRepository.save(dorm);
	}
	
	public void delete(Dorm dorm) {
		dormRepository.delete(dorm);
	}
}
