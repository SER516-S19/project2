package com.Quizzer.code.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Quizzer.code.model.Question;

public interface QuestionRepo extends MongoRepository<Question, String> {

	public Optional<Question> findById(String id);
}
