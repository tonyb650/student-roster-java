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

import com.tonyb650.studentroster.models.Class;
import com.tonyb650.studentroster.models.Dorm;
import com.tonyb650.studentroster.models.Student;
import com.tonyb650.studentroster.services.ClassService;
import com.tonyb650.studentroster.services.DormService;
import com.tonyb650.studentroster.services.StudentService;

import jakarta.validation.Valid;

@Controller
public class DormController {

	@Autowired
	DormService dormService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	ClassService classService;
	
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
	
	@GetMapping("/classes/new")
	public String newClass(@ModelAttribute("class") Class thisClass) {
		return "newclass.jsp";
	}
	
	@GetMapping("/students/new")
	public String newStudent(@ModelAttribute("modelStudent") Student student, Model model) {
		model.addAttribute("dorms", dormService.getAllDorms());
		return "newstudent.jsp";
	}
	
	@GetMapping("/classes")
	public String showClasses(Model model) {
		model.addAttribute("classes", classService.getAllClasses());
		return "classlist.jsp";
	}
	
	@GetMapping("/dorms/{id}")
	public String dormDetail(@PathVariable("id") Long id, @ModelAttribute("student") Student student, Model model) {
		Dorm dorm = dormService.findDormById(id);
		model.addAttribute("dorm", dorm);
		List<Student> allStudents = studentService.allStudents();
		model.addAttribute("allStudents", allStudents);
		return "dormdetail.jsp";
	}
	
	@GetMapping("/classes/{id}/detail")
	public String classDetail(@PathVariable("id") Long classId, Model model) {
		model.addAttribute("thisClass", classService.getClassById(classId));
		return "classdetail.jsp";
	}
	
	@GetMapping("/students/{id}/detail")
	public String studentDetail(@PathVariable("id") Long studentId, Model model) {
		// DONE: adjust the following line to only include classes that are not assigned already:
		Student thisStudent = studentService.findStudentById(studentId);
		model.addAttribute("allClasses", classService.getUnassignedClassesForStudent(thisStudent));
		//model.addAttribute("allClasses",classService.getAllClasses());
		model.addAttribute("student", studentService.findStudentById(studentId));
		return "studentdetail.jsp";
	}
	
	@PutMapping("/students/{id}/addclass")
	public String addStudentToClass(@PathVariable("id") Long studentId, @RequestParam("id") Long classId) {
		Student thisStudent = studentService.findStudentById(studentId);
		Class thisClass = classService.getClassById(classId);
		thisStudent.getClasses().add(thisClass);
		studentService.update(thisStudent);
		return "redirect:/students/"+studentId+"/detail";
	}
	
	@GetMapping("/classes/{classId}/remove/{studentId}") // I believe this should be PUT
	public String removeStudentFromClass(@PathVariable("classId") Long classId, @PathVariable("studentId") Long studentId) {
		Student thisStudent = studentService.findStudentById(studentId);
		Class thisClass = classService.getClassById(classId);
		thisStudent.getClasses().remove(thisClass);
		studentService.update(thisStudent);
		return "redirect:/students/"+studentId+"/detail";
	}
	
	@PutMapping("/students/update/{dormId}") // RESTful maybe should be "/students/{id}" or "/students/{id}/assigndorm" ?
	public String updateStudent(@PathVariable("dormId") Long dormId, @RequestParam("id") Long id) {
		Student studentToUpdate = studentService.findStudentById(id);
		studentToUpdate.setDorm(dormService.findDormById(dormId));
		studentService.update(studentToUpdate);
		return "redirect:/dorms/"+dormId;
	}
	
	@PostMapping("/dorms/new") // RESTful convention should be "/dorms"
	public String createDorm(@Valid @ModelAttribute("dorm") Dorm dorm, BindingResult validationsResult) {
		if(validationsResult.hasErrors()) {
			return "newdorm.jsp";
		}
		dormService.create(dorm);
		return "redirect:/dorms";
	}
	
	@PostMapping("/students/new") // RESTful convention should be "/students"
	public String createStudent(@Valid @ModelAttribute("modelStudent") Student aStudent, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dorms", dormService.getAllDorms());
			return "newstudent.jsp";
		}
		studentService.create(aStudent);
		return "redirect:/dorms";
	}
	
	@PostMapping("/classes/new")  // RESTful convention should be "/classes"
	public String addClass(@Valid @ModelAttribute("class") Class thisClass, BindingResult result) {
		if(result.hasErrors()) {
			return "newclass.jsp";
		}
		classService.create(thisClass);
		return "redirect:/dorms";
	}
	
	@PostMapping("/students/{id}/remove/{dormId}") // I'm pretty sure this should be PUT
	public String removeFromDorm(@PathVariable("id") Long id,@PathVariable("dormId")Long dormId) {
		Student studentToUpdate = studentService.findStudentById(id);
		studentToUpdate.setDorm(null);
		studentService.update(studentToUpdate);
		return "redirect:/dorms/"+dormId;
	}
	
}
