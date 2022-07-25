package com.cg.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.school.entity.User;

public interface UserRepository extends JpaRepository <User,Integer> {

	User findByUserId(int id);

}
