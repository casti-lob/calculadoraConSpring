package com.jacaranda.primerSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.primerSpring.model.Student;
import com.jacaranda.primerSpring.services.StudentService;



@Controller
public class StudentController {
	@Autowired
	StudentService repositorio;
	
	@GetMapping("list")
	public String listStudent(Model model) {
		model.addAttribute("list", repositorio.getStudentList());
		return "listStudent";
	}
	
	@GetMapping("add")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("newStudent", student);
		return "addStudent";
	}
	
	@PostMapping("add/submit")
	public String addSubmit(@ModelAttribute("newStudent") Student student) {
		repositorio.addStudent(student);
		return "redirect:/list";
	}
	
	@GetMapping("delStudent")
	public String deleteStudent(Model model, 
			@RequestParam(name="name",required=false,defaultValue="")String name,
			@RequestParam(name="lastName",required=false,defaultValue="")String surname
			
			) {
		Student student = repositorio.getStudent(name, surname);
		model.addAttribute("student", student);
		return "deleteStudent";
	}
	
	@PostMapping("delStudent/submit")
	public String deleteSubmit(@ModelAttribute("student") Student student) {
		repositorio.removeStudent(student);
		return "redirect:/list";
	}
	
	@GetMapping("editStudent")
	public String editStudent(Model model, @RequestParam(name="name", required = false, defaultValue = "")
	String name, @RequestParam(name="lastName", required = false, defaultValue = "")String surname) {
		Student student = repositorio.getStudent(name,surname );
		model.addAttribute("student", student);
		return "editStudent";
	}
	
	@PostMapping("editStudent/submit")
	public String editSubmit(@ModelAttribute("student") Student student) {
		repositorio.editStudent( student.getName(), student.getLastName(), student.getAge());
		return "redirect:/list";
	}
}
