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
        <form className="FormCenter" onSubmit={this.handleSignIn}>
          <div className={'FormField' + (submitted && !username ? ' has-error' : '')}>
            <label className="FormField__Label" htmlFor="email">E-Mail Address</label>
            <input type="email" className="FormField__Input" placeholder="Enter your email" name="username" value={username} onChange={this.handleChange} />
            {submitted && !username &&
            <div className="help-block">Email is required</div>
            }
          </div>
          <div className={'FormField' + (submitted && !password ? ' has-error' : '')}>
            <label className="FormField__Label" htmlFor="password">Password</label>
            <input type="password" id="password" className="FormField__Input" placeholder="Enter your password" name="password" value={password} onChange={this.handleChange} />
            {submitted && !password &&
            <div className="help-block">Password is required</div>
            }
          </div>
          <div className="FormField">
            <button className="FormField__Button mr-20" disabled={loading}>Login</button>
            {loading &&
            <img src="data:images/loading.gif;base64,
            R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/
            C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh
            +QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIj
            K8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUk
            GCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/
            jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==" />
            }
            <Link to="/" className="FormField__Link">Create an account</Link>
          </div>
          {error &&
          <div className={'alert alert-danger'}>{error}</div>
          }
        </form>
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
