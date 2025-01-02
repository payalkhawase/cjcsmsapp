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

	@RequestMapping("/search")
    public String getBatchStudent(@RequestParam("batchNumber") String batchNumber,Model m) {
		List<Student> result=ssi.searchStudentsByBatch(batchNumber);
		if(result.size()>0) {
			m.addAttribute("data", result);
		}else {
			
			List<Student> Students=ssi.getAllStudents();
			m.addAttribute("data", Students);
			m.addAttribute("msg", "No records available fot the batch"+batchNumber+"'.....!");
		}
		return "adminscreen";
	}
	@RequestMapping("/fees")
	public String onFees(@RequestParam("id") int id,Model m) {
		Student s=ssi.getStudent(id);
		m.addAttribute("st", s);
		return "fees";
	}
	
	@RequestMapping("/payfees")
	public String PayFees(@RequestParam("studentid") int id,@RequestParam("ammount") float amt,Model m) {
	
		List<Student> list=ssi.updateStudentFees(id,amt);
		m.addAttribute("data", list);
		return "adminscreen";
	}
	
	@RequestMapping("/batch")
	public String onBatch(@RequestParam("id") int id,Model m) {
		Student s=ssi.getStudent(id);
		m.addAttribute("st", s);
		return "batch";
	}
	
	@RequestMapping("/shiftbatch")
	public String ShiftBatch(@RequestParam("studentid") int id,@RequestParam("batchNumber") String batchNumber,Model m) {
	
		List<Student> l= ssi.updateStudentBatch(id,batchNumber);
		m.addAttribute("data", l);
		return "adminscreen";
	}
	
	@RequestMapping("/remove")
	public String removeDelete(@RequestParam("id") int id,Model m) {
		
		       ssi.removeStudent(id);
		
		List<Student> list=ssi.getAllStudents();
		m.addAttribute("data",list);
		return "adminscreen";
	}
	
	@RequestMapping("/paging")
	public String paging(@RequestParam("pageNo") int pageNo,Model m) {
		

		List<Student> list=ssi.paging(pageNo,2);
		m.addAttribute("data",list);
		return "adminscreen";
	}
	
}
