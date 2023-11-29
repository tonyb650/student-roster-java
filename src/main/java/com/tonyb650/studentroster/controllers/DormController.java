package com.tonyb650.studentroster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tonyb650.studentroster.models.Dorm;
import com.tonyb650.studentroster.models.Student;
import com.tonyb650.studentroster.services.DormService;
import com.tonyb650.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class DormController {

	@Autowired
	DormService dormService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dorms";
	}
	
	@GetMapping("/dorms")
	public String dormList(Model model) {
		model.addAttribute("dorms", dormService.getAllDorms());
		return "dormlist.jsp";
	}
	
	@GetMapping("/dorms/new")
	public String newDorm(@ModelAttribute("dorm") Dorm dorm) {
		return "newdorm.jsp";
	}
	
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("modelStudent") Student student, Model model) {
		model.addAttribute("dorms", dormService.getAllDorms());
		return "newstudent.jsp";
	}
	
	@GetMapping("/dorms/{id}")
	public String dormDetail(@PathVariable("id") Long id, @ModelAttribute("student") Student student, Model model) {
		Dorm dorm = dormService.findDormById(id);
		model.addAttribute("dorm", dorm);
		List<Student> allStudents = studentService.allStudents();
		model.addAttribute("allStudents", allStudents);
		return "dormdetail.jsp";
	}
	
	@PutMapping("/students/update/{dormId}")
	public String updateStudent(@PathVariable("dormId") Long dormId, @RequestParam("id") Long id) {
		Student studentToUpdate = studentService.findStudentById(id);
		studentToUpdate.setDorm(dormService.findDormById(dormId));
		studentService.update(studentToUpdate);
		return "redirect:/dorms/"+dormId;
	}
	
	@PostMapping("/dorms/new")
	public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult validationsResult) {
		if(validationsResult.hasErrors()) {
			return "newdorm.jsp";
		}
		dormService.create(dorm);
		return "redirect:/dorms";
	}
	
	@PostMapping("/students/new")
	public String createStudent(@Valid @ModelAttribute("modelStudent") Student aStudent, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dorms", dormService.getAllDorms());
			return "newstudent.jsp";
		}
		studentService.create(aStudent);
		return "redirect:/dorms";
	}
	
	@PostMapping("/students/{id}/remove/{dormId}")
	public String removeFromDorm(@PathVariable("id") Long id,@PathVariable("dormId")Long dormId) {
		Student studentToUpdate = studentService.findStudentById(id);
		studentToUpdate.setDorm(null);
		studentService.update(studentToUpdate);
		return "redirect:/dorms/"+dormId;
	}
	
}
