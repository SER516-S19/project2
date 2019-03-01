import React, { Component } from 'react';
import HoriChart from './HoriChart';
import PiChart from './PiChart';
import './Dashboard.css';

class Dashboard extends Component {
    constructor(props) {
        super(props);
        this.state = {

        };
    }

    render() {
        return (
            <div>
                <div className="container">
                    <div className="row">
                        <div className="chart col lg6">
                            <HoriChart/>
                        </div>
                        <div className="chart col lg6">
                            <PiChart/>
                        </div>
                    </div>
                    <div className="row">
                        <div className="chart col lg6">
                            <HoriChart/>
                        </div>
                        <div className="chart col lg6">
                            <PiChart/>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Dashboard;