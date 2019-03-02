import React, { Component } from 'react';
import { Link, Route, Redirect } from 'react-router-dom';
import '../index.css';
import Routes from '../../../Routes';
import Home from '../../../pages/Home/Home';
class LogInForm extends Component {


  handleSignIn(e) {
    // e.preventDefault();
    let username = this.refs.username.value;
    let password = this.refs.password.value;
    this.props.onSignIn(username, password);
  }

  render() {
    return (
      <div>
        <div className="FormCenter">
              <div className="FormFields">
                <div className="FormField">
                  <label className="FormField__Label" htmlFor="email">E-Mail Address</label>
                  <input type="email" id="username" className="FormField__Input" placeholder="Enter your email" name="email" ref="username" />
                </div>

                <div className="FormField">
                  <label className="FormField__Label" htmlFor="password">Password</label>
                  <input type="password" id="password" className="FormField__Input" placeholder="Enter your password" name="password" ref="password" />
                </div>

                <div className="FormField">
                  <button className="FormField__Button mr-20" onClick={this.handleSignIn.bind(this)} >Sign In</button> <Link to="/" className="FormField__Link">Create an account</Link>
                </div>
              </div>
            </div>
      </div>
    );
  }
}

class SignInForm extends Component {
  constructor() {
    super();
    localStorage.clear();
    this.state = {
      user: null,
      type: -1
    };

  }


  signIn(username, password) {
    // This is where you would call Firebase, an API etc...
    // calling setState will re-render the entire app (efficiently!)
    var type = -1;
    if (username.toString().localeCompare("Prof") === 0) {
      type = 1;
      this.setState({
        type: type,
        user: {
          username,
          password
        }
      });
    } else {
      type = 0;
      this.setState({
        type: type,
        user: {
          username,
          password
        }
      });
    }
    localStorage.setItem('username', username);
    localStorage.setItem('password', password);
    localStorage.setItem('type', type);
  }

  render() {
    return (
      <div>
        {
          
            (this.state.user) ?
                <Redirect to='/home' Component={Home}/>
                :
                <LogInForm onSignIn={this.signIn.bind(this)}/>


        }
      </div>


    );
  }
}

export default SignInForm;
