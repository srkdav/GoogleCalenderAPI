package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.dao.IUserDao;
import com.app.models.UserModel;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserDao dao;
	
	@PostMapping("/SetUser")
	public ResponseEntity<UserModel> registerUser(@RequestBody UserModel u) {
		
		dao.register(u);
		return new ResponseEntity<UserModel> (u,HttpStatus.OK);
	}
}
