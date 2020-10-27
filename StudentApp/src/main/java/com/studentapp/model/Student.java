package com.studentapp.model;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="student")
@TypeAlias("Student")
public class Student {

	@Id
	Integer studId;
	String name;
	String dept;
	Integer age;
	
	@Autowired
    Address address;
	
	
	public Student(Integer studId, String name, String dept, Integer age, Address address) {
		super();
		this.studId = studId;
		this.name = name;
		this.dept = dept;
		this.age = age;
		this.address = address;
	}

	public Integer getStudId() {
		return studId;
	}
	public void setStudId(Integer studId) {
		this.studId = studId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "student [studId=" + studId + ", name=" + name + ", dept=" + dept + ", age=" + age + ", address="
				+ address + "]";
	}
	

}
