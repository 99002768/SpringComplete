package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class GreetServiceImpl implements GreetService{

	@Override
	public String showMessage(String name) {
		// TODO Auto-generated method stub
		return "have a great day";
	}

	@Override
	public String welcomeUser(String name) {
		// TODO Auto-generated method stub
		return "welcome"+name.toUpperCase();
	}

	@Override
	public String printName(String name) {
		// TODO Auto-generated method stub
		return "hello"+name.toLowerCase();
	}

}
