package com.cg.school.controller;

import java.util.List;

import javax.validation.Valid;

import com.cg.school.advice.TrackExecutionTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.school.dto.Student;
import com.cg.school.entity.User;
import com.cg.school.exception.UserNotFoundException;
import com.cg.school.service.UserService;



@RestController
@RequestMapping("/api")
public class UserController {
	Logger log = LoggerFactory.getLogger(UserController.class);



	@Autowired
	private UserService service;

	@PostMapping("/reg")
	public ResponseEntity<User> saveUser(@RequestBody @Valid Student student) throws UserNotFoundException {
		return new ResponseEntity<>(service.saveUser(student), HttpStatus.CREATED);
	}


	@GetMapping("/reg")
	@TrackExecutionTime
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(service.getAllUsers());

	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
		return ResponseEntity.ok(service.getUser(id));
	}

}
