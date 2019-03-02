import React, { Component } from 'react';
import HoriChart from './HoriChart';
import PiChart from './PiChart';
import './Dashboard.css';
import { axios } from 'axios';


class Dashboard extends Component {

    constructor(props) {
        super(props);
        this.state = {
            quizNames:[],
            averageMarks:[],
            medians:[]
        };

    fetch('http://localhost:8081/prof/stats')
      .then(response => response.json())
      .then(data => {
          this.setState({
            quizNames : data.quizNames,
            averageMarks: data.averageMarks,
            medians : data.medians
          });
      });

    }

   



    render() {

        

        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className="chart col lg6">
                            <HoriChart />
                            {this.state.quizNames}
                        </div>
                        <div className="chart col lg6">
                            <PiChart />
                        </div>
                    </div>
                    <div className="row">
                        <div className="chart col lg6">
                            <HoriChart />
                        </div>
                        <div className="chart col lg6">
                            <PiChart />
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Dashboard;