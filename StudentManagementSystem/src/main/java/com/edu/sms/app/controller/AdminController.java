package com.edu.sms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edu.sms.app.model.Student;
import com.edu.sms.app.servicei.StudentService;

@Controller
public class AdminController {
@Autowired
StudentService ssi;
	@RequestMapping("/")
	public String prelLogin() {
		
		return "login";
	}
	
	@RequestMapping("/login")
	public String onLogin(@RequestParam("username") String username,@RequestParam("password") String password,Model m) {
		if(username.equals("admin") && password.equals("admin")) {
			List<Student> list=ssi.getAllStudents();
			m.addAttribute("data", list);
		return "adminscreen";
	}else
	{
		return "login";
	}
}
	@RequestMapping("/enroll_student")
	public String saveStudent(@ModelAttribute Student s,Model m) {
		ssi.saveStudent(s);
		
		return "adminscreen";
	}
}
