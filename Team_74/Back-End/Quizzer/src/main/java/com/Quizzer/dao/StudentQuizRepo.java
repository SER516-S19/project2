package com.Quizzer.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Quizzer.model.db.StudentQuiz;

/**
 * This repository implements the mongo repository for StudentQuiz table.
 * 
 * @author Kirti Jha
 */
public interface StudentQuizRepo extends MongoRepository<StudentQuiz, String> {

	public Optional<StudentQuiz> findByStudentId(String id);
}
