package com.Quizzer.code.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Quizzer.code.model.db.Quiz;

public interface QuizRepo extends MongoRepository<Quiz, String> {

	public Optional<Quiz> findById(String id);

	public Quiz findByName(String name);

}
