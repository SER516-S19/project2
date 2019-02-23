import React, {Component} from 'react';
import './Home.css';
import {NavLink} from 'react-router-dom';
import ListGroupItem from "react-bootstrap/ListGroupItem";
import ListGroup from "react-bootstrap/ListGroup";

import {
    Card, CardBody
} from 'reactstrap';
import QuizInstruction from '../Professor/QuizInstruction/QuizInstruction';

class Home extends Component {
    
    
    constructor(props, context) {
        super(props, context);
        // the initial application state
        this.state = {
            isProfessorType: ((parseInt(localStorage.getItem('type'),10) === 0)? false : true ),
            isCreatingQuiz: false
        }
        this.handleSubmit = this.handleSubmit.bind(this);
        
    }
    
    handleSubmit(event) {
        event.preventDefault();
        this.setState({
            isCreatingQuiz: this.state.isCreatingQuiz ? false: true
        })
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit}>
                <div className="Home">
                    {
                        (this.state.isProfessorType)?
                            <div>
                                {
                                (this.state.isCreatingQuiz)?
                                <button type="submit" className="Prof-Button" value="Submit">Back</button>
                                : 
                                <button type="submit" className="Prof-Button" value="Submit">Create Quiz</button>
                            }
                            <center>
                            <h3>Professor Portal</h3>
                            {
                                (this.state.isCreatingQuiz)?
                                <h5>Create Quiz for your students</h5>
                                : 
                                <h5>Welcome to your home page</h5>
                            }
                            <br></br></center>
                            {
                                (this.state.isCreatingQuiz)?
                                <QuizInstruction/>
                                : 
                                <label></label>
                            }
                            
                            </div>

                            :

                            <div>
                                <CardBody>
                                    <center>
                                    <h3>Student Portal</h3>
                                    <h5>Click on the Quiz to be completed</h5>
                                    <br></br></center>
                                    
                                    <ListGroup>
                                        <Card> 
                                            <ListGroupItem>
                                                <li><NavLink exact activeClassName="current" to='/takeQuiz'>Quiz 1</NavLink>
                                                </li>
                                            </ListGroupItem>
                                            
                                            <ListGroupItem>
                                                <li><NavLink exact activeClassName="current" to='/takeQuiz'>Quiz 2</NavLink>
                                                </li>
                                            </ListGroupItem>
                                            <ListGroupItem>
                                                <li><NavLink exact activeClassName="current" to='/takeQuiz'>Quiz 3</NavLink>
                                                </li>
                                            </ListGroupItem>
                                        </Card>
                                    </ListGroup>
                                </CardBody>
                            </div>
                    }
                </div>
            </form>
        );
    }
}

export default Home;
