import React, { Component } from 'react';
import { Pie } from 'react-chartjs-2';

class PiChart extends Component {
    constructor(props) {
        super(props);
        this.state = {
             data : {
                labels: [
                    'Red',
                    'Green',
                    'Yellow'
                ],
                datasets: [{
                    data: [300, 50, 100],
                    backgroundColor: [
                    '#FF6384',
                    '#36A2EB',
                    '#FFCE56'
                    ],
                    hoverBackgroundColor: [
                    '#FF6384',
                    '#36A2EB',
                    '#FFCE56'
                    ]
                }]
            }
        };
    }
    
    render() {
        return (
            <div>
                <h2>Pie Example</h2>
                <Pie data={this.state.data} />
            </div>
        );
    }
}

export default PiChart;