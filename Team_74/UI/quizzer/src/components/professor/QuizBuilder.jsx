import React, { useState } from "react";
import { FaPlus, FaSave } from 'react-icons/fa';
import { Col, Row } from 'reactstrap';
import ListController from "../../controllers/ListController";
import Question from "../../models/Question";
import './Questions.css';
import QuizQuestion from "./QuizQuestion";

export default function QuizBuilder(props) {

  const [questions, setQuestions] = useState([
    new Question({
      questionText: "What's your favorite color?",
      marks: 5,
      options: ["Blue", "Orange", "White", "Purple"]
    })
  ]);

  const listController = new ListController(questions, setQuestions);

  const myHandler = (e, props) => {
    listController.setInstructions(props.location.state.data);
    listController.submit();
  }

  return (

    <div className="small-container">
      <ol className="spacer">
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

      <Row>
        <Col>
          <button onClick={() => listController.add(new Question())}>
            <span><FaPlus /></span>
            Add Question
      </button>
        </Col>

        <Col>
          <button onClick={(e) => myHandler(e, props)}>
            <span><FaSave /></span>
            Create Quiz
      </button>
        </Col>
      </Row>
    </div>
  );
}