package com.edu.sms.app.servicei;

import java.util.List;

import com.edu.sms.app.model.Student;

public interface StudentService {

	public List<Student> getAllStudents();

	public void saveStudent(Student s);

	public List<Student> searchStudentsByBatch(String batchNumber);

	public Student getStudent(int id);

	public List<Student> updateStudentFees(int id, float amt);

	public void removeStudent(int id);

	public List<Student> paging(int pageNo, int i);

	public List<Student> updateStudentBatch(int id, String batchMode);

}
