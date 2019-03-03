import React, { Component } from 'react';
import { Pie } from 'react-chartjs-2';

class PiChart extends Component {
    constructor(props) {
        super(props);
        this.state = {
            data: {
                labels: [],
                datasets: [{
                    data: [],
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

    componentDidMount() {
        fetch('http://localhost:8081/prof/stats')
            .then(response => response.json())
            .then(response_json => {
                this.setState(

                    {
                        data: {
                            labels: response_json.quizNames,
                            datasets: [{
                                data: response_json.medians,
                                backgroundColor: this.getRandomColor(response_json.quizNames.length),
                                hoverBackgroundColor: this.getRandomColor(response_json.quizNames.length),
                            }]
                        }
                    });
            });
    }

    getRandomColor(length) {
        var colors = [];
        while (colors.length < length) {
            colors.push("#" + ((1 << 24) * Math.random() | 0).toString(16));
        }
        return colors;
    }

    render() {
        return (
            <div style={{marginBottom:"3em"}}>
                <h3 style={{textAlign:"center"}}>Median per quiz</h3>
                <Pie data={this.state.data} />
            </div>
        );
    }
}

export default PiChart;