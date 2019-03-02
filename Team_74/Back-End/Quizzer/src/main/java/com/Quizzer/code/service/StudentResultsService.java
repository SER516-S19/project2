package com.Quizzer.code.service;

import com.Quizzer.code.dao.SubmitQuizRepo;
import com.Quizzer.code.exceptions.StudentResultsException;
import com.Quizzer.code.model.db.SubmitQuiz;
import com.Quizzer.code.model.response.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


/**
 * This is the service layer for add quiz, get quizzes.
 *
 * @author Kumar Prabhu Kalyan and Kirti Jha
 *
 */
@Service
public class StudentResultsService {

    @Autowired
    SubmitQuizRepo submitQuizRepo;

    public ResponseEntity<ResponseVO> addResult(SubmitQuiz submitQuiz) throws StudentResultsException {
        ResponseVO response = new ResponseVO(HttpStatus.OK.toString(), "", "");
        if (submitQuiz != null) {
            submitQuiz.setId(null);

            try {

                if (addResultRepo(submitQuiz)) {
                    return new ResponseEntity<>(new ResponseVO(HttpStatus.OK.toString(), "", ""), HttpStatus.OK);
                }

            } catch (StudentResultsException e) {
                response.setStatus("500");
                response.setErrorMessage("Internal Server Error!");
                return new ResponseEntity<ResponseVO>(response, HttpStatus.OK);
            }
        }

            response.setStatus("400");
            response.setErrorMessage("Null Request");
            return new ResponseEntity<ResponseVO>(response, HttpStatus.OK);

    }

    private boolean addResultRepo(SubmitQuiz submitQuiz) throws StudentResultsException {
        try {
            submitQuiz.setMarksAchieved(submitQuiz.getMarksAchieved());
            submitQuiz.setQuiz(submitQuiz.getQuiz());
            submitQuiz.setQuizId(submitQuiz.getQuizId());
            submitQuiz.setStudentId(submitQuiz.getStudentId());
            submitQuizRepo.insert(submitQuiz);

            return true;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new StudentResultsException(ex.getMessage());
        }

    }
}
