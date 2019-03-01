import React, { Component } from 'react';
import { Link, Route, Redirect } from 'react-router-dom';
import '../index.css';
import Routes from '../../../Routes';
import Home from '../../../pages/Home/Home';
class LogInForm extends Component {


  handleSignIn(e) {
    //e.preventDefault();
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
      type: '0'
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(e) {
    let target = e.target;
    let value = target.type === 'checkbox' ? target.checked : target.value;
    let name = target.name;

    this.setState({
      [name]: value
    });
  }

  signIn(username, password) {
    // This is where you would call Firebase, an API etc...
    // calling setState will re-render the entire app (efficiently!)

    this.setState({
      user: {
        username,
        password
      }
    })

    this.setState({
      type: '1'
    });

    // if (!this.state.username.toString().localeCompare("Prof") === 0) {
    //   this.setState({
    //     type: '1'
    //   });
    // } else {
    //   this.setState({
    //     type: '0'
    //   });
    // }

    localStorage.setItem('username',username);
    localStorage.setItem('password',password);
    localStorage.setItem('type',this.state.type);
  }



  handleSubmit(e) {
    e.preventDefault();
    console.log('yo:');

    if (this.state.email.toString().localeCompare("Prof") === 0) {
      this.setState({
        type: '1'
      });
    } else {
      this.setState({
        type: '0'
      });
    }
    localStorage.setItem('username', this.state.email);
    localStorage.setItem('password', this.state.password);
    localStorage.setItem('type', this.state.type);

    // return <Redirect push to="/home" /> ;
    console.log('The form was submitted with the following data:');
    console.log(this.state);
  }

  render() {
    return (
      <div>
        {
          (this.state.type === '1') ?
            <div>
              <Routes/>
              <Redirect to='/home' Component={Home}/>
            </div>
            :
            <LogInForm onSignIn={this.signIn.bind(this)}/>

        }
      </div>


    );
  }
}

export default SignInForm;
