import React, { Component } from 'react';
import './App.css';
import Routes from './Routes';
import Navigation from './Navigation'

class App extends Component {

  render() {
    return (
      <div className="App">
        <div className="App-header">
          <h2>Demo Canvas</h2>
        </div>
        <Navigation />
        <Routes />
      </div>
    );
  }
}

export default App;
