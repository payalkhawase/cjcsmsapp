package com.edu.sms.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.sms.app.model.Student;
import com.edu.sms.app.repository.StudentRepo;
import com.edu.sms.app.servicei.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepo sr;
	@Override
	public List<Student> getAllStudents() {
		
		return sr.findAll();
	}
	@Override
	public void saveStudent(Student s) {
		
		sr.save(s);
		
	}
	@Override
	public List<Student> searchStudentsByBatch(String batchNumber) {
		
		List<Student> batchStudents=sr.findAllByBatchNumber(batchNumber);
		
		return batchStudents;
	}

}
