package com.edu.sms.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.sms.app.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{

}
