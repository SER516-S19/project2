import React from 'react'

import './Toolbar.css'
import { Container, Row, Col, Label, Button } from 'reactstrap';
import { Link, Route, Redirect } from 'react-router-dom';


const Toolbar = props => {
  const handleClick = () => {
      localStorage.clear();
      return(
        <Redirect to = '/login'/>
      );
  };

  return(
    <Container>
      <Row>
      <header className="toolbar">
      <nav className="toolbar__navigation">
      <div />
      <div className="toolbar__logo">
        <a href="/">THE BLACKBORD</a>
      </div>
      <div className="space"></div>
      <div className="toolbar__logo">
      <a href="/home">{props.title}</a>
      </div>

      <div className="spacer" />
      <div className="toolbar_navigation-items">
        <ul>
          <li>
            <a href="/home">Home</a>
          </li>
          <li>
            <a href="/dash">Dashboard</a>
          </li>
          <li>
            <button onClick={handleClick}> Sign Out </button>>
          </li>
        </ul>
      </div>
    </nav>
  </header>

      </Row>
    </Container>

  );
  }

export default Toolbar