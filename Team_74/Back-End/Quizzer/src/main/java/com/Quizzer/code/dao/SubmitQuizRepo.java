package com.Quizzer.code.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Quizzer.code.model.db.Quiz;
import com.Quizzer.code.model.db.SubmitQuiz;

/**
 * This repository implements the mongo repository for StudentQuiz table.
 * 
 * @author Kirti Jha
 */
public interface SubmitQuizRepo extends MongoRepository<SubmitQuiz, String> {

	public List<SubmitQuiz> findByStudentId(String id);

	public List<SubmitQuiz> findByQuizId(String id);

	public Quiz findByStudentIdAndQuizId(String studentId, String quizId);

}
