import React, { Component } from 'react';
import './App.css';
import Routes from './Routes';
import Navigation from './components/Navigation'
import { NavLink, Route, Router, Redirect } from 'react-router-dom';
import LoginApp from './components/NewLogin/LoginApp';
import Home from './pages/Home/Home';
import Toolbar from './components/Nav/Toolbar';

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            title: ((parseInt(localStorage.getItem('type'),10) === 0)? "Student's Portal" : "Professor's Portal" ),

        }
    }
    

    render() {

        return (
            <div style = {{height:"100vh"}}>
                {
                    (localStorage.getItem('username')) ?
                        <div className="App">
                            <div>
                            <Toolbar title={this.state.title}/>
                            </div>
                            <div>
                            <Home />                           
                            </div>
                        </div>

                        :
                         <div className="App">
                            <LoginApp />
                        </div>
                }

            </div>
        );
    }

    signOut() {
        // clear out user from localstorage
        localStorage.clear();
    }
}

export default App;
