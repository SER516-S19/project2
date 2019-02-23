package com.Quizzer.code.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Quizzer.code.model.db.Student_Quiz;

public interface Student_QuizRepo extends MongoRepository<Student_Quiz, String> {

	public Optional<Student_Quiz> findBystudentId(String id);
}
