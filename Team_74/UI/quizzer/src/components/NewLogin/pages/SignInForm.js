import axios from "axios";
import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import '../index.css';

class SignInForm extends Component {
  constructor(props) {
    super(props);

    localStorage.clear();
    this.state = {
      username: '',
      password: '',
      submitted: false,
      loading: false,
      error: ''
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSignIn = this.handleSignIn.bind(this);
  }

  handleChange(e) {
    const { name, value } = e.target;
    this.setState({ [name]: value });
  }
  handleSignIn(e) {
    e.preventDefault();
    this.setState({ submitted: true });
    const { username, password } = this.state;

    // stop here if form is invalid
    if (!(username && password)) {
      return;
    }

    this.setState({ loading: true });

    axios.post('http://localhost:8081/login', {
    userPassword: password,
    userEmailId: username
  })
      .then((response) => {
        if (response.data.response != null) {
          console.log(response);
          localStorage.setItem('username', username);
          localStorage.setItem('password', password);
          localStorage.setItem('type', response.data.response.role);
          const {from} = this.props.location.state || {from: {pathname: "/home"}};
          this.props.history.push(from)
        }else{
          this.setState({ error: response.data.errorMessage , loading: false });
          const {from} = this.props.location.state || {from: {pathname: "/login"}};
          this.props.history.push(from)
        }
      },
      error => this.setState({ error, loading: false })
  );
  }

  render() {
    const { username, password, submitted, loading, error } = this.state;
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
            <button className="FormField__Button mr-20" disabled={loading}>
            {loading &&
            <img src="data:images/loading.gif;base64,
            R0lGODlhEAAQAPIAAP///wAAAMLCwkJCQgAAAGJiYoKCgpKSkiH/
            C05FVFNDQVBFMi4wAwEAAAAh/hpDcmVhdGVkIHdpdGggYWpheGxvYWQuaW5mbwAh
            +QQJCgAAACwAAAAAEAAQAAADMwi63P4wyklrE2MIOggZnAdOmGYJRbExwroUmcG2LmDEwnHQLVsYOd2mBzkYDAdKa+dIAAAh+QQJCgAAACwAAAAAEAAQAAADNAi63P5OjCEgG4QMu7DmikRxQlFUYDEZIGBMRVsaqHwctXXf7WEYB4Ag1xjihkMZsiUkKhIAIfkECQoAAAAsAAAAABAAEAAAAzYIujIj
            K8pByJDMlFYvBoVjHA70GU7xSUJhmKtwHPAKzLO9HMaoKwJZ7Rf8AYPDDzKpZBqfvwQAIfkECQoAAAAsAAAAABAAEAAAAzMIumIlK8oyhpHsnFZfhYumCYUhDAQxRIdhHBGqRoKw0R8DYlJd8z0fMDgsGo/IpHI5TAAAIfkECQoAAAAsAAAAABAAEAAAAzIIunInK0rnZBTwGPNMgQwmdsNgXGJUlIWEuR5oWUIpz8pAEAMe6TwfwyYsGo/IpFKSAAAh+QQJCgAAACwAAAAAEAAQAAADMwi6IMKQORfjdOe82p4wGccc4CEuQradylesojEMBgsUc2G7sDX3lQGBMLAJibufbSlKAAAh+QQJCgAAACwAAAAAEAAQAAADMgi63P7wCRHZnFVdmgHu2nFwlWCI3WGc3TSWhUFGxTAUk
            GCbtgENBMJAEJsxgMLWzpEAACH5BAkKAAAALAAAAAAQABAAAAMyCLrc/
            jDKSatlQtScKdceCAjDII7HcQ4EMTCpyrCuUBjCYRgHVtqlAiB1YhiCnlsRkAAAOwAAAAAAAAAAAA==" />
            }
               Login   </button>
            <Link to="/" className="FormField__Link">Create an account</Link>
          </div>
          {error &&
          <div className={'alert alert-danger'}>{error}</div>
          }
        </form>
    );
  }
}

export default SignInForm;
