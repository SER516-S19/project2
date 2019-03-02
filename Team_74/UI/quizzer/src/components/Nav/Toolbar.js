import React, { Component } from 'react'

import './Toolbar.css'
import { Container, Row, Col, Label, Button } from 'reactstrap';
import { Link, Route, Redirect, BrowserRouter, withRouter } from 'react-router-dom';
import App from '../../App';


class Toolbar extends Component {

  constructor(props) {
    super(props);
    // this.state = {
    //   redirectToLoginPage : false,
    //   redirectToHome: false,
    //   redirectToDashboard: false
    // }
  }

//   state = {
//     redirectToLoginPage : false,
//     redirectToHome: false,
//     redirectToDashboard: false
// }
  setRedirect = (event) => {
    const target = event.target;
    const value = target.value;
    const name = target.name;

    if (name == "redirectToLoginPage") {
      localStorage.clear();
      this.props.history.push("/");
      // return <Redirect to='/' />
    }
    if (name == "redirectToDashboard") {
      this.props.history.push("/dash");

      // return <Redirect to='/dash' />
    }
    if (name == "redirectToHome") {
      this.props.history.push("/home");

      // return <Redirect to='/home' />
    }
    // this.setState({
    //   [name]: value
    // });
  }
  // renderRedirect = () => {
    
  // }

  // componentDidUpdate(){
  //   // this.resetState();
  // }

  // resetState(){
  //   this.state = {
  //     redirectToLoginPage : false,
  //     redirectToHome: false,
  //     redirectToDashboard: false
  //   }
  // }
  render(){
    return(
      <div>
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
              {/* {this.renderRedirect()} */}

        <Col>
        {/* <li> */}
            {/* <a href="/home">Home</a> */}
            {/* <menuitem name="redirectToHome" value = "true" onClick={this.setRedirect}> Home </menuitem> */}
            <button name="redirectToHome" value = "true" onClick={this.setRedirect}> Home </button>

          {/* </li> */}
        </Col>
        <Col>
            {/* <a href="/dash">Dashboard</a> */}
            <button name="redirectToDashboard" value = "true" onClick={this.setRedirect}> Dashboard </button>
        </Col>
        <Col>
            <button name="redirectToLoginPage" value = "true" onClick={this.setRedirect}> Sign Out </button>
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