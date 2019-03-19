import React, { Component } from 'react';
import { HorizontalBar } from 'react-chartjs-2';

class HoriChart extends Component {

    constructor(props) {
        super(props);
        this.state = {
            data: {
                labels: [],
                datasets: [
                    {
                        label: 'Average Marks per Quiz',
                        backgroundColor: 'rgba(255,99,132,0.2)',
                        borderColor: 'rgba(255,99,132,1)',
                        borderWidth: 1,
                        hoverBackgroundColor: 'rgba(255,99,132,0.4)',
                        hoverBorderColor: 'rgba(255,99,132,1)',
                        data: [],
                    }
                ]
            }
        };
    }

    getRandomColor(length) {
        var colors = [];
        while (colors.length < length) {
            colors.push("#" + ((1 << 24) * Math.random() | 0).toString(16));
        }
        return colors;
    }

    componentDidMount() {
        fetch('http://localhost:8081/prof/stats')
            .then(response => response.json())
            .then(response_json => {
                this.setState({
                    data: {
                        labels: response_json.quizNames,
                        datasets: [
                            {
                                label: 'Average Marks per Quiz',
                                backgroundColor: 'rgba(255,99,132,0.2)',
                                borderColor: 'rgba(255,99,132,1)',
                                borderWidth: 1,
                                hoverBackgroundColor: 'rgba(255,99,132,0.4)',
                                hoverBorderColor: 'rgba(255,99,132,1)',
                                data: response_json.averageMarks,
                            }
                        ]
                    }
                });
            });
    }


    render() {
        return (
            <div style={{ marginBottom: "3em" }}>
                <h3 style={{ textAlign: "center" }}>Mean marks of quizes</h3>
                <HorizontalBar data={this.state.data} />
            </div>
        );
    }
}

export default HoriChart;