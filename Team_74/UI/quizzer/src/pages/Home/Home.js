import React, { Component } from 'react';
import './Home.css';
import { NavLink } from 'react-router-dom';
import ListGroupItem from "react-bootstrap/ListGroupItem";
import ListGroup from "react-bootstrap/ListGroup";

class Home extends Component {


    constructor(props, context) {
        super(props, context);
        // the initial application state
        this.state = {
            type: 0
        }
    }

    render() {
        return (
            <div className="Home">
                {
                    (parseInt(localStorage.getItem('type'),10) === 0)?
                        <div>
                                <center>
                                    <h3>Student Portal</h3>
                                    <h5>Click on the Quiz to be completed</h5>
                                    <br></br></center>

                                <ListGroup className="QuizList">
                                    <ListGroupItem><li><NavLink exact activeClassName="current" to='/takeQuiz'>Quiz 1</NavLink></li></ListGroupItem>
                                    <ListGroupItem><li><NavLink exact activeClassName="current" to='/takeQuiz'>Quiz 2</NavLink></li></ListGroupItem>
                                    <ListGroupItem><li><NavLink exact activeClassName="current" to='/takeQuiz'>Quiz 3</NavLink></li></ListGroupItem>
                                </ListGroup>
                            </div>
                    :

                        <div>
                            <button type="button" className="Prof-Button" >Professor</button>
                            <center>
                                <h3>Professor Portal</h3>
                                <h5>Select Quiz to be edited</h5>
                                <br></br></center>

                            {/*<ListGroup className="QuizList">*/}
                                {/*<ListGroupItem><li><NavLink exact activeClassName="current" to='/takeQuiz'>Quiz 1</NavLink></li></ListGroupItem>*/}
                                {/*<ListGroupItem><li><NavLink exact activeClassName="current" to='/takeQuiz'>Quiz 2</NavLink></li></ListGroupItem>*/}
                                {/*<ListGroupItem><li><NavLink exact activeClassName="current" to='/takeQuiz'>Quiz 3</NavLink></li></ListGroupItem>*/}
                            {/*</ListGroup>*/}


                        </div>


                }
            </div>
        );
    }
}

export default Home;
