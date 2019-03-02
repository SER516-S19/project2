import React from 'react';
import { NavLink, Switch } from "react-router-dom";
import Routes from '../Routes';
import { BrowserRouter as Router } from 'react-router-dom'
import { Route, Redirect } from 'react-router-dom';
import TakeQuiz from '../pages/Student/TakeQuiz/TakeQuiz';
import { Link } from 'react-router-dom';

class QuizListService extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            quizList: [],
            isStudent: ((parseInt(localStorage.getItem('type'), 10) === 0) ? true : false),
            isQuizActiveCallback : this.props.callbackFunc
        }
    }

    

    componentDidMount() {

        var quizNameList = [];
        fetch('http://localhost:8081/prof/quiz')
            .then(response => response.json())
            .then(response_json => {
                console.log([...response_json.response]);
                this.setState({
                    quizList: [...response_json.response]
                });
            }
            );
    }

    render() {
        return (
            <div>
                <Switch>
                    <QuizList data={this.state} />
                </Switch>
            </div>
        )
    }
}

class QuizList extends React.Component {
    constructor(props) {
        super(props);
        console.log(props);
        this.updateQuizSection = this.updateQuizSection.bind(this);
    }
    updateQuizSection() {
        this.props.data.isQuizActiveCallback();
     }
    

    render() {
        let view;
        const isStudent = this.props.data.isStudent;
        const quizList = this.props.data.quizList;
        if (isStudent) {
            view = Object.keys(quizList).map(function (key) {
                return <li className="list-group-item list-group-item-info" onClick={this.updateQuizSection}>
                    <Link to="TakeQuiz" to={{
                            pathname: '/takeQuiz/:quizId',
                            quizId: quizList[key].quizId.toString()
                        }}>{quizList[key].quizName} </Link>
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
                <Router>
                    <div>
                        {view}
                        <Switch>
                            <Route exact path='/takeQuiz/:quizId' component={TakeQuiz} />
                        </Switch>
                    </div>
                </Router>
            </div>


        );
    }
}



export default QuizListService;