package com.citigo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.citigo.model.School;
import com.citigo.model.Student;
import com.citigo.service.SchoolService;
import com.citigo.service.StudentService;

@Controller
public class StudentCTRL {
	
	@Autowired
	private StudentService studentservice;
	
	@Autowired
	private SchoolService schoolservce;
	
	@ModelAttribute(value="listschool")
	public List<School> initSchool(){
		List<School> list = schoolservce.getAllSchool();
		return list;
	}

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String showListStudent(Model model) {
		List<Student> list = studentservice.getAllStudent();
		model.addAttribute("liststudent", list);
		return "student";
	}

	@RequestMapping(value = "/addstudent", method = RequestMethod.GET)
	public String addStudent(Model model) {
		Student obj = new Student();
		model.addAttribute("student", obj);
		return "addstudent";
	}

	@RequestMapping(value = "/addstudent", method = RequestMethod.POST)
	public String saveStudent(Model model, @ModelAttribute(value = "student") Student student) {
		studentservice.addStudent(student);
		return "redirect: student";
	}

	@RequestMapping(value = "/editstudent", method = RequestMethod.GET)
	public String editShow(Model model, Student obj) {
		obj = studentservice.getStudentById(obj.getId());
		model.addAttribute("student", obj);
		return "editstudent";
	}

	@RequestMapping(value = "/editstudent", method = RequestMethod.POST)
	public String editSave(Model model, @ModelAttribute(value = "student") Student student) {
		studentservice.updateStudent(student);
		return "redirect: student";
	}

	@RequestMapping(value = "/deletestudent", method = RequestMethod.GET)
	public String deleteStudent(Model model, Student obj) {
		studentservice.deleteStudent(obj);
		return "redirect: student";
	}
}
