import React, { useState } from "react";
import QuizTitle from "./QuizTitle";
import QuizQuestion from "./QuizQuestion";
import { useInputValue } from "../../hooks";
import Question from "../../models/Question";
import ListController from "../../controllers/ListController";
import { FaPlus, FaSave } from 'react-icons/fa';
import './Questions.css';

export default function QuizBuilder() {
  const [title, handleChangeTitle] = useInputValue("Enter Quiz Title Here");

  const [questions, setQuestions] = useState([
     new Question({
      questionText: "What's your favorite color?",
       marks:5,
       options: ["Blue", "Orange", "White", "Purple"]
     })
    
  ]);

  const listController = new ListController(questions, setQuestions);

  return (
    <div className="small-container">
      <QuizTitle title={title} handleChangeTitle={handleChangeTitle} />

      <ol>
        {questions.map((question, i) => (
          <QuizQuestion
            key={question.id}
            question={question}
            setQuestion={question => listController.set(i, question)}
            removeQuestion={() => listController.remove(i)}
            moveQuestionUp={() => listController.moveUp(i)}
            moveQuestionDown={() => listController.moveDown(i)}
          />
        ))}
      </ol>

      <div>
      <button onClick={() => listController.add(new Question())}>
        <span><FaPlus /></span>
        Add Question
      </button>

      <span>   </span>
     <button onClick={() => listController.submit()}>
        <span><FaSave /></span>
         Create Quiz
      </button>
     </div>
    </div>
  );
}
