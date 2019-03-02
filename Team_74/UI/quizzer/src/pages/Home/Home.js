import React, { Component } from 'react';
import './Home.css';
import ListGroup from "react-bootstrap/ListGroup";
import QuizListService from '../../api/QuizListService'


import {
    Card, CardBody
} from 'reactstrap';
import QuizInstruction from '../Professor/QuizInstruction/QuizInstruction';
import Toolbar from '../../components/Nav/Toolbar';
import Routes from '../../Routes';



class Home extends Component {


    constructor(props, context) {
        super(props);
        // the initial application state
        this.state = {
            isProfessorType: ((parseInt(localStorage.getItem('type'), 10) === 0) ? false : true),
            isCreatingQuiz: false,
            quizList: [],
            isViewMounted: false,
            isQuizActive: false

        }
        this.handleSubmit = this.handleSubmit.bind(this);
        this.updateQuizSection = this.updateQuizSection.bind(this);
        // console.log(QuizListService.props.quizList);
        // var i = quizListService.length;
        // while ()

    }

    componentDidMount() {
        this.setState({
            isViewMounted: true
        })
    }

    handleSubmit(event) {
        event.preventDefault();
        this.setState({
            isCreatingQuiz: this.state.isCreatingQuiz ? false : true
        })
    }

    updateQuizSection() {
        this.setState({
            isQuizActive: true
        })

        console.log("Called");
    }

    render() {
        // console.log(this.state.quizList[0].quizName);
        return (

            <div>

                {
                    (this.state.isProfessorType) ?
                        <div style={{ width: "100%" }}>
                            {
                                (this.state.isCreatingQuiz) ?
                                    <button type="submit" className="Prof-Button" onClick={this.handleSubmit} value="Submit">Back</button>
                                    :
                                    <button type="submit" className="Prof-Button" onClick={this.handleSubmit} value="Submit">Create Quiz</button>
                            }
                            <center>
                                {/* <h3>Professor Portal</h3> */}
                                {
                                    (this.state.isCreatingQuiz) ?
                                        <h5>Create Quiz for your students</h5>
                                        :
                                        <div>
                                            <h5>Welcome to your home page</h5>
                                            <CardBody>
                                                <ListGroup>
                                                    <Card>
                                                        <QuizListService />
                                                    </Card>
                                                </ListGroup>
                                            </CardBody>
                                        </div>
                                }
                            </center>
                            {
                                (this.state.isCreatingQuiz) ?
                                    <QuizInstruction />
                                    :
                                    <label></label>
                            }

                        </div>

                        :

                      

                            
                             <ListGroup>
                             <center>
                                        <h3>Welcome Student</h3>
                                        <h5>Click on the Quiz to be completed</h5>
                                        <br></br></center>
                                        <CardBody>
                                    <ListGroup>
                                        <Card>
                                            <QuizListService  />
                                        </Card>
                                    </ListGroup>
                                </CardBody>
                         </ListGroup> 
                            
                }
            </div>
        );
    }
}

export default Home;
