import React, { Component } from 'react';
import './App.css';
import Dashboard from './components/Dashboard/Dashboard';
import Toolbar from './components/Nav/Toolbar';
import LoginApp from './components/NewLogin/LoginApp';
import Home from './pages/Home/Home';

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            isDashShown: false,
            isHomeShown: true
        }

        this.dashboardHandler = this.dashboardHandler.bind(this);
        this.homeHandler = this.homeHandler.bind(this);

    }

    dashboardHandler() {
        this.setState({
            isDashShown: true,
            isHomeShown: false
        })
    }
    homeHandler() {
        this.setState({
            isDashShown: false,
            isHomeShown: true
        })
    }
    render() {
        let title = ((parseInt(localStorage.getItem('type'), 10) === 0) ? "Student's Portal" : "Professor's Portal");
        let isProfessorType = ((parseInt(localStorage.getItem('type'), 10) === 0) ? false : true);

        let com;
        if (isProfessorType && this.state.isDashShown) {
            com = <Dashboard />
        } else if (this.state.isHomeShown) {
            com = <Home />
        }

        return (
            <div style={{ height: "100vh" }}>
                {
                    (localStorage.getItem('username')) ?
                        <div className="App">
                            <div>
                                <Toolbar title={title} isProfessor={isProfessorType} dashboardHandler={this.dashboardHandler} homeHandler={this.homeHandler} />
                            </div>
                            <div style={{ width: "100%", marginTop: "56px" }}>
                                {com}
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
