import React, { Component } from 'react'

import './Toolbar.css'
import { Container, Row, Col, Label, Button } from 'reactstrap';
import { Link, Route, Redirect, BrowserRouter } from 'react-router-dom';
import App from '../../App';


class Toolbar extends Component {

  constructor(props) {
    super(props);
    this.state = {
      redirect : false
    }
  }

  state = {
    redirect: false
  }
  setRedirect = () => {
    this.setState({
      redirect: true
    })
  }
  renderRedirect = () => {
    if (this.state.redirect) {
      localStorage.clear();
      return <Redirect to='/' />
    }
  }

  render(){
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
      <a href="/home">{this.props.title}</a>
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
          {this.renderRedirect()}
          <li>
            <button onClick={this.setRedirect}> Sign Out </button>>
          </li>
        </ul>
      </div>
    </nav>
  </header>

      </Row>
    </Container>

    )
  }

}

export default Toolbar