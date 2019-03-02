import React, { Component } from 'react';
import './App.css';
import Routes from './Routes';
import Navigation from './components/Navigation'
import { NavLink, Route, Router, Redirect } from 'react-router-dom';
import LoginApp from './components/NewLogin/LoginApp';
import Home from './pages/Home/Home';

class App extends Component {
    render() {

        return (
            <div>
                {
                    (localStorage.getItem('username')) ?
                        <div className="App">
                        <Home />
                           
                            {/* <Navigation />
                            <Routes />
                            <NavLink to="/login">
                            <button type="button" className="logout-button" onClick={this.signOut}>
                                SignOut
                            </button>
                            </NavLink> */}

                        </div>

                        :
                         <div className="App">
                         <LoginApp />
                        
                             {/* <div className="App-header">
                                <h1>Demo Canvas</h1>
                             </div> */}
                            {/* <div className="Blank-Nav"/>  */}

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
