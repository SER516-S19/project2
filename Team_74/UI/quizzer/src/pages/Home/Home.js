import React, {Component} from 'react';
import './Home.css';
import ListGroup from "react-bootstrap/ListGroup";
import QuizListService from '../../api/QuizListService'


import {
    Card, CardBody
} from 'reactstrap';
import QuizInstruction from '../Professor/QuizInstruction/QuizInstruction';
import Toolbar from '../../components/Nav/Toolbar';



class Home extends Component {
    

    constructor(props, context) {
        super(props);
        // the initial application state
        this.state = {
            isProfessorType: ((parseInt(localStorage.getItem('type'),10) === 0)? false : true ),
            isCreatingQuiz: false,
            quizList: [],
            isViewMounted: false

        }
        this.handleSubmit = this.handleSubmit.bind(this);
        // console.log(QuizListService.props.quizList);
        // var i = quizListService.length;
        // while ()
        
    }

    componentDidMount(){
        this.setState({
            isViewMounted: true
        })
    }
    // componentDidMount() {
    //     var self = this;
    //     axios.get("http://localhost:8081/prof/quiz")
    //         // .then(response => response.json())
    //         .then(response =>{
    //             console.log(response);
    //             this.setState({
    //                 quizList: response.data.response
    //             })
    //         })
    //
    //         .then(function(response){
    //             console.log(self.state.quizList[0].quizName);
    //
    //
    //         })
    // }

    handleSubmit(event) {
        event.preventDefault();
        this.setState({
            isCreatingQuiz: this.state.isCreatingQuiz ? false: true
        })
    }

    render() {
        // console.log(this.state.quizList[0].quizName);
        return (
                
                <div className="Home">
                    {
                        (this.state.isProfessorType)?
                            <div>
                                {
                                (this.state.isCreatingQuiz)?
                                <button type="submit" className="Prof-Button" onClick={this.handleSubmit} value="Submit">Back</button>
                                : 
                                <button type="submit" className="Prof-Button" onClick={this.handleSubmit} value="Submit">Create Quiz</button>
                            }
                            <center>
                            {/* <h3>Professor Portal</h3> */}
                            {
                                (this.state.isCreatingQuiz)?
                                <h5>Create Quiz for your students</h5>
                                : 
                                // <></>
                                <h5>Welcome to your home page</h5>
                            }
                            </center>
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
                                    <h3>Welcome Student</h3>
                                    <h5>Click on the Quiz to be completed</h5>
                                    <br></br></center>

                                   <ListGroup>
                                        <Card>

                                            <QuizListService/>
                                            {/*<ListGroupItem>*/}
                                                {/*/!*<li><NavLink exact activeClassName="current" to='/takeQuiz'>Quiz 1</NavLink>*!/*/}
                                                {/*/!*</li>*!/*/}
                                                {/*<QuizListService/>*/}

                                            {/*</ListGroupItem>*/}
                                            
                                            {/*<ListGroupItem>*/}
                                                {/*<li><NavLink exact activeClassName="current" to='/takeQuiz'>Quiz 2</NavLink>*/}
                                                {/*</li>*/}
                                            {/*</ListGroupItem>*/}
                                            {/*<ListGroupItem>*/}
                                                {/*<li><NavLink exact activeClassName="current" to='/takeQuiz'>Quiz 3</NavLink>*/}
                                                {/*</li>*/}
                                            {/*</ListGroupItem>*/}
                                        </Card>
                                    </ListGroup>
                                </CardBody>
                            </div>
                    }
                </div>
        );
    }
}

export default Home;
