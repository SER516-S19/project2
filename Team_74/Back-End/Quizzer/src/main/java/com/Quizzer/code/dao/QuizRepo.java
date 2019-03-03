package com.Quizzer.code.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Quizzer.code.model.db.Quiz;

/**
 * This repository implements the mongo repository for Quiz table.
 * 
 * @author Kumar Prabhu Kalyan
 *
 */
public interface QuizRepo extends MongoRepository<Quiz, String> {

	public Optional<Quiz> findById(String id);

	public Quiz findByName(String name);

}
