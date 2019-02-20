import React, { Component } from 'react';
import './App.css';
import Routes from './Routes';
import Navigation from './Navigation'
import { NavLink } from 'react-router-dom';


class App extends Component {


    render() {
        return (
            <div>
                {
                    (localStorage.getItem('username')) ?
                        <div className="App">
                            <div className="App-header">
                                <h2>Demo Canvas</h2>

                            </div>

                            <Navigation />
                            <Routes />
                            <NavLink to="/login"><button type="button" className="logout-button" onClick={this.signOut}>SignOut</button></NavLink>
                        </div>

                        :
                        <div className="App">
                            <div className="App-header">
                                <h2>Demo Canvas</h2>

                            </div>
                            <div className="Blank-Nav"/>
                            <Routes />

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
