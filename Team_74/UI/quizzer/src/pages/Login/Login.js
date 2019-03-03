import React from 'react';
import './Login.css';
import { Redirect } from 'react-router-dom';

class LoginForm extends React.Component {

  // Class based component to access DOM refs
  handleSignIn(e) {
    e.preventDefault()
    let username = this.refs.username.value;
    let password = this.refs.password.value;
    this.props.onSignIn(username, password);
  }

  render() {
    return (
        <form className="LoginForm" onSubmit={this.handleSignIn.bind(this)}>
          <div className="Login-formheader">
            <h3>Sign in</h3>
          </div>
          <input type="text" ref="username" required={true} placeholder="Enter your username" />
          <input type="password" ref="password" required={true} placeholder="Enter password" />
          <input type="submit" value="Login" />
        </form>
    )
  }
}

class Login extends React.Component {
  constructor(props) {
    super(props)
    localStorage.clear();
    // the initial application state
    this.state = {
      user: null,
      type: 0
    }
  }

  // App "actions" (functions that modify state)
  signIn(username, password) {
    // This is where you would call Firebase, an API etc...
    // calling setState will re-render the entire app (efficiently!)

    this.setState({
      user: {
        username,
        password,
      }
    })

    if (username.toString().localeCompare("Prof") === 0){
      this.state.type = 1;
    }else{
      this.state.type = 0;
    }
    localStorage.setItem('username',username);
    localStorage.setItem('password',password);
    localStorage.setItem('type',this.state.type);
  }

  render() {

    // Passing relevant state to child components as props.
    // Functions are passed using `bind` to make sure we keep our scope to App
    return (
        <div>
          {
            (this.state.user) ?
                <Redirect to='/home' />
                :
                <LoginForm
                    onSignIn={this.signIn.bind(this)}
                />
          }
        </div>
    )
  }
}

export default Login;
