import React, { Component } from 'react'

import './Toolbar.css'
import { Container, Row, Col, Label, Button } from 'reactstrap';
import { Link, Route, Redirect, BrowserRouter } from 'react-router-dom';
import App from '../../App';


class Toolbar extends Component {

  constructor(props) {
    super(props);
    this.state = {
      redirectToLoginPage : false,
      redirectToHome: false,
      redirectToDashboard: false
    }
  }

  state = {
    redirectToLoginPage : false,
    redirectToHome: false,
    redirectToDashboard: false
}
  setRedirect = (event) => {
    const target = event.target;
    const value = target.type === 'checkbox' ? target.checked : target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }
  renderRedirect = () => {
    if (this.state.redirectToLoginPage) {
      localStorage.clear();
      return <Redirect to='/' />
    }
    if (this.state.redirectToDashboard) {
      return <Redirect to='/dash' />
    }
    if (this.state.redirectToHome) {
      return <Redirect to='/home' />
    }
  }

  render(){
    return(
      <Container>
      <Row>
      <header className="toolbar">
      <nav className="toolbar__navigation">

      <Col className="toolbar__logo">
        <a href="/">THE BLACKBORD</a>
      </Col>

      <Col xs={6}>
      <div className="toolbar__title">
      <a href="/home">{this.props.title}</a>
      </div>

      </Col>

      <Col className="toolbar__menu">
        <Col>
        {/* <li> */}
            {/* <a href="/home">Home</a> */}
            <button name="redirectToHome" value = "true" onClick={this.setRedirect}> Home </button>

          {/* </li> */}
        </Col>
        <Col>
            {/* <a href="/dash">Dashboard</a> */}
            <button name="redirectToDashboard" value = "true" onClick={this.setRedirect}> Dashboard </button>
        </Col>
        <Col>
        {this.renderRedirect()}
            <button name="redirectToLoginPage" value = "true" onClick={this.setRedirect}> Sign Out </button>
        </Col>
      </Col>
    </nav>
  </header>

      </Row>
    </Container>

    )
  }

}

export default Toolbar