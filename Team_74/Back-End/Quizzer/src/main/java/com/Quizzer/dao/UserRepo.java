package com.Quizzer.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Quizzer.model.db.User;

public interface UserRepo extends MongoRepository<User, String> {

	public User findByUserEmailId(String emailId);
}
