import React, { Component } from 'react';
import { withRouter } from 'react-router-dom';
import { Col, Row } from 'reactstrap';
import './Toolbar.css';



class Toolbar extends Component {

  constructor(props) {
    super(props);
  }

  //Used to route to several pages based on the menu clicked
  setRedirect = (event) => {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    if (name == "redirectToLoginPage") {
      localStorage.clear();
      this.setState(this.getInitialState);
      this.props.history.push("/");

    }
    if (name == "redirectToDashboard") {
      { this.props.dashboardHandler() };
      this.setState(this.getInitialState);
    }
    if (name == "redirectToHome") {
      { this.props.homeHandler() };
      this.setState(this.getInitialState);
    }
  }

  render() {
    return (
      <div>
        <Row>
          <header className="toolbar">
            <nav className="toolbar__navigation">

              <Col className="toolbar__logo">
                <a href="/">THE BLACKBORD</a>
              </Col>

              <Col xs={6}>
                <div className="toolbar__title">
                  <a href="/">{this.props.title}</a>
                </div>

              </Col>

              <Col className="toolbar__menu">
                <Col>
                  <button name="redirectToHome" value="true" onClick={this.setRedirect}> Home </button>
                </Col>
                <Col hidden={!this.props.isProfessor}>
                  <button name="redirectToDashboard" value="true" onClick={this.setRedirect}> Dashboard </button>
                </Col>
                <Col>
                  <button name="redirectToLoginPage" value="true" onClick={this.setRedirect}>Sign Out</button>
                </Col>
              </Col>
            </nav>
          </header>

        </Row>
      </div>

    )
  }

}

export default withRouter(Toolbar)