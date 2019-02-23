package com.Quizzer.code.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Quizzer.code.model.db.Question;

/**
 * This repository implements the mongo repository for Question table.
 * 
 * @author Kumar Prabhu Kalyan
 *
 */
public interface QuestionRepo extends MongoRepository<Question, String> {

	public Optional<Question> findById(String id);

	public List<Question> findByQuizId(String quizId);
}
