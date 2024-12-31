package com.edu.sms.app.servicei;

import java.util.List;

import com.edu.sms.app.model.Student;

public interface StudentService {

	public List<Student> getAllStudents();

	public void saveStudent(Student s);

}
