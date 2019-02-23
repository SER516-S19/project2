import React, { useState } from "react";
import styled from "styled-components";
import { FaPen, FaSave } from 'react-icons/fa';
import './Questions.css';

export default function QuizTitle({ title, handleChangeTitle }) {
  const [editing, setEditing] = useState(false);

  function toggleEditing() {
    setEditing(!editing);
  }

  return (
    <Title>
      <Heading>
        {editing ? (
          <input type="text" value={title} onChange={handleChangeTitle} />
        ) : (
          title
        )}
      </Heading>
      <button onClick={toggleEditing}>
        {editing ? (
          <>
           <FaSave/>
             Save Title
          </>
        ) : (
          <>
            <FaPen/>
             Edit Title 
          </>
        )}
      </button>
    </Title>
  );
}

const Title = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

const Heading = styled.h1`
  flex: 1 0;
  margin-right: 0.3em;
`;

const button = styled.h1`
  flex: 1 0;
  margin-right: 0.3em;
  width: 5%;
`;