import React, { useState } from "react";
import QuestionForm from "./QuestionForm";
import styled from "styled-components";
import { FaSave, FaPen, FaTrashAlt, FaAngleDown, FaAngleUp } from 'react-icons/fa';
import './Questions.css';

export default function QuizQuestion({
  question,
  setQuestion,
  removeQuestion,
  moveQuestionUp,
  moveQuestionDown
}) {
  const [editing, setEditing] = useState(false);
 

  function toggleEditing() {
    setEditing(!editing);
  }

  return (
    <QuestionField>
      {editing ? (
        <QuestionForm question={question} setQuestion={setQuestion} />
      ) : (
        <>
          <div>{question.questionText} <Right>Marks: {question.marks}</Right> </div>
          {question.hasOptions ? (
            question.options.map((option, i) => (
              <label key={i}>
                <input
                  type={question.inputType}
                  id={option}
                  name={option}
                  value={option}
                  disabled
                />
                {option}
              </label>
            ))
          ) : (
            <textarea disabled />
          )}
        </>
      )}
      <Button onClick={toggleEditing}>
        {editing ? (
          <>
            <FaSave />
            Save Question
          </>
        ) : (
          <>
            <FaPen />
            Edit Question
          </>
        )}
      </Button>
      <Button onClick={removeQuestion}>
        <FaTrashAlt />
        Delete Question
      </Button>
      <br />
      Move Question:{" "}
      <Button onClick={moveQuestionUp}>
        <FaAngleUp />
        Up
      </Button>
      <Button onClick={moveQuestionDown}>
        <FaAngleDown />
        Down
      </Button>
    </QuestionField>
  );
}

const QuestionField = styled.li`
  margin-top: 1em;
  border-top: #ddd solid 1.5px
  padding-bottom: 1.5em;
`;

const Button = styled.button`
  margin: 0.3em;
`;

const Right = styled.span`
position: relative;
float: right;
`;

