import React from 'react';
import { NavLink } from "react-router-dom";

class QuizListService extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            quizList: [],
            isStudent: ((parseInt(localStorage.getItem('type'),10) === 0)? true : false )
        }
    }


    componentDidMount() {

        var quizNameList = [];
        fetch('http://localhost:8081/prof/quiz')
            .then(response => response.json())
            .then(response_json => {
                console.log([...response_json.response]);
                this.setState({  
                    quizList:  [...response_json.response]
                }); 
            }
            );
    }

    render() {
        return (
            <div>
                <QuizList data={this.state} />
            </div>
        )
    }
}

class QuizList extends React.Component {
    constructor(props) {
        super(props);
        console.log(props);
    }
    
    render() {
        let view;
        const isStudent = this.props.data.isStudent;
        const quizList = this.props.data.quizList;
        if (isStudent) {
            view = Object.keys(quizList).map(function (key) {
                return <li className="list-group-item list-group-item-info">
                    <NavLink exact activeClassName="current" to={'/takeQuiz?quizId=' + quizList[key].quizId.toString()}>
                        {quizList[key].quizName}
                    </NavLink>
                </li>
            }.bind(this))
        } else {
            view = Object.keys(quizList).map(function (key) {
                return <li className="list-group-item list-group-item-info">
                    <p>{quizList[key].quizName}</p>
                </li>
            }.bind(this))
        }

        return (
            <div className="container">
                <ul className="list-group text-center">
                    {
                        view
                    }
                </ul>
            </div>
        );
    }
}



export default QuizListService;