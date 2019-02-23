import React, {Component} from 'react';
import './QuizInstruction.css';
import { Container, Row, Col, Label, Button } from 'reactstrap';

class QuizInstruction extends Component {
    constructor(props){
        super(props);
        this.state = {
            titleText: '',
            description: '',
            shouldShuffle: false,
            quizType: 'default',
            assignmentGroup: 'default'
        };
        
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
        
    }
    
    handleChange(event) {
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;
        
        this.setState({
            [name]: value
        });
    }
    
    handleSubmit(event) {
        alert('Quiz : ' + this.state.titleText +' submitted');
        event.preventDefault();
    }
    
    render(){
        return (
            <Container className = "quizInstruction" onSubmit={this.handleSubmit}>
            <Row>
              <Col>
                <input name = "title" type="text" placeholder="Enter Quiz Title" value={this.state.value} 
                  onChange={this.handleChange} />
              </Col>            
            </Row>
            <Row>
              <Col className= "padding"> Quiz Instruction: </Col>
              
            </Row>
            <Row>
            <Col >
            <textarea  className = "descriptionTextArea" placeholder = "Enter description here ..." 
              name = "description" type="text" value={this.state.value} onChange={this.handleChange} />
              </Col>            

            </Row>
            <Row>
              <Col className= "padding"></Col>
            </Row>
            <Row >
              <Col className="rightAlign">
                <Label > Choose quiz type:</Label>
              </Col>
              <Col className="leftAlign" xs>
                <select  name = "quizType" value={this.state.quizType} onChange={this.handleChange}>
                <option value="mcq">MCQ</option>
                <option value="survey">Survey</option>
                <option value="default">Default</option>
                </select>
              </Col>
            </Row>            
            <Row>
            <Col className="rightAlign">
            <label> Assignment Group:</label>
            </Col>
            <Col className="leftAlign">
            <select name = "assignmentGroup"  value={this.state.assignmentGroup} onChange={this.handleChange}>
            <option value="quiz">Quiz</option>
            <option value="test">Test</option>
            <option value="default">Default</option>
            </select>
            </Col>
            </Row>
            
            <Row>
            <Col className="rightAlign">
            <label> Options: </label>
            </Col>
            <Col className="leftAlign">
            </Col>
            </Row>
            
            <Row>
            <Col className="rightAlign">
            <label> Shuffle: </label>
            </Col>
            <Col className="leftAlign">
            <input
            name="shouldShuffle"
            type="checkbox"
            checked={this.state.shouldShuffle}
            onChange={this.handleChange} />
            
            </Col>
            </Row>
            <Row className="justify-content-md-center">
            <Button type="submit"> Next </Button>
            </Row>
            </Container>
            
        )
    }
}
QuizInstruction.propTypes = {
}

export default QuizInstruction;
