package com.Quizzer.code.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Quizzer.code.model.db.User;

/**
 * This repository implements the mongo repository for User table.
 *
 * @author Kumar Prabhu Kalyan
 *
 */
public interface UserRepo extends MongoRepository<User, String> {

	//	public User findByUserName(String userName);
	public User findByUserEmailId(String emailId);
}
