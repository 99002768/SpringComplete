package com.studentapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapp.exception.StudentNotFoundException;
import com.studentapp.model.Student;
import com.studentapp.service.StudentService;

@RestController
@RequestMapping("/student-api")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/students")
	ResponseEntity<Student> addBook(@RequestBody Student student) {
		
		Student nstudent = studentService.addStudent(student);
        return ResponseEntity.ok(nstudent);
		
	}
	
	  @DeleteMapping("/students/delete-one/{stuId}")
	    ResponseEntity<Void> deleteBook(@PathVariable("stuId")Integer stuid) throws StudentNotFoundException{
	        studentService.deleteStudent(stuid);
	        return ResponseEntity.status(HttpStatus.OK).build();
	    }
	
	@GetMapping("/stdents/get-one/{stuId}")
	ResponseEntity<Student> getBookById(@PathVariable("stuId")Integer stuId) throws StudentNotFoundException{
		
		Student nstudent = studentService.getStudentById(stuId);
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Getting Student by Id");
        header.add("title", "One Student");
        return ResponseEntity.status(HttpStatus.OK)
                .headers(header).body(nstudent);
		
	}

}
