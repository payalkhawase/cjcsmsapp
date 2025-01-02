package com.edu.sms.app.serviceimpl;

import java.util.List;
import java.util.Optional;

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
	@Override
	public Student getStudent(int id) {
		
		return sr.findById(id).get();
	}
	@Override
	public List<Student> updateStudentFees(int id, float amt) {
		
		Optional<Student> op = sr.findById(id);
		if (op.isPresent()) {
			Student s = op.get();
			s.setFeesPaid(s.getFeesPaid() + amt);
			sr.save(s);
		}

		return sr.findAll();
	}
	@Override
	public void removeStudent(int id) {

           sr.deleteById(id);
		
	}
	

}
