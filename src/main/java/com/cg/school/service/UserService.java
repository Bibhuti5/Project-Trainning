package com.cg.school.service;

import java.util.List;

import com.cg.school.advice.TrackExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.school.controller.UserController;
import com.cg.school.dto.Student;
import com.cg.school.entity.User;
import com.cg.school.exception.UserNotFoundException;
import com.cg.school.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
public abstract class

UserService {
	Logger log = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private UserRepository repository;

	@TrackExecutionTime
	public User saveUser(Student student) throws UserNotFoundException{
		User user =User.build(0,student.getFirstName(),student.getLastName(),student.getDob(),student.getStandarded(),student.getFatherName(),student.getMotherName(),student.getPhone(),student.getAddress());
		log.debug("Post User data {}", user);
		List<User> userslist = repository.findAll();
		for(User i : userslist){
			if((i.getFirstName().equals(student.getFirstName()))&&(i.getFatherName().equals(student.getFatherName()))){
				log.debug("Checking if Student already exists");
				throw new UserNotFoundException("Student already exists");
			}
		}
		return repository.save(user);
	}


	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@TrackExecutionTime
	public User getUser(int id) throws UserNotFoundException {
		User user = repository.findByUserId(id);
		if (user != null) {
			return user;
		} else {
			throw new UserNotFoundException("Student  not found with id : " + id);
		}
	}

	public abstract void registerUser(Student student);
}
