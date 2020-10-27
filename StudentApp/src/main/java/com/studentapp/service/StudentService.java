package com.studentapp.service;

import java.util.List;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;

public interface StudentService {

	Student addStudent(Student student);
	Student getStudentById(int id);
	boolean deleteStudent(Integer studentid);
	
}
