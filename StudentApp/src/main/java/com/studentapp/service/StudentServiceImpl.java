package com.studentapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.studentapp.dao.StudentRepository;
import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	
	@Autowired
	StudentRepository studentRepository;
	
	public StudentServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Student addStudent(Student student) {
		 Student newstudent = studentRepository.save(student);
			return newstudent;
	}

	@Override
	public boolean deleteStudent(Integer studentid) {
		studentRepository.deleteById(studentid);
		return true;
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepository.findById(id)
                .orElseThrow(()-> new StudentNotFoundException("Id not available"));
		// TODO Auto-generated method stub
		
	}
	
}
