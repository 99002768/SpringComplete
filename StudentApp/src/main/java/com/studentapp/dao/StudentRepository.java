package com.studentapp.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.studentapp.model.Student;

@Repository
public interface StudentRepository extends MongoRepository<Student,Integer>{
	
	List<Student>findByAddressCity(String city);
	List<Student>findByDept(String dept);
}
