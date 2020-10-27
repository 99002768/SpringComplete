package com.lt.training;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceImpl implements GreetService {

	public String greet(String name) {
		// TODO Auto-generated method stub
		return "hello"+name;
	}

}
