import React from 'react';
import axios from 'axios';
import {NavLink} from "react-router-dom";

class QuizListService extends React.Component {
    state = {
        quizList: []
    }
    componentDidMount() {
            var self = this;
            axios.get("http://localhost:8081/prof/quiz")
                .then(response => response.json())
                .then(response =>{
                    console.log(response);
                    this.setState({
                        quizList: response.data.response
                    })
                })

                .then(function(response){
                    console.log(self.state.quizList[0].quizName);
                })
    }
    render() {
        return (
            <div>
                <QuizList quizList={this.state.quizList}/>
            </div>
        )
    }
}

class QuizList extends React.Component{
    render() {
        return (
            <div className="container">
                <ul className="list-group text-center">
                    {
                        Object.keys(this.props.quizList).map(function(key) {
                            return <li className="list-group-item list-group-item-info">
                                <NavLink exact activeClassName="current" to={'/takeQuiz?quizId='+this.props.quizList[key].quizId.toString()}>
                                    {this.props.quizList[key].quizName}
                                </NavLink></li>
                        }.bind(this))
                    }
                </ul>
            </div>
        );
    }
}

export default QuizListService;