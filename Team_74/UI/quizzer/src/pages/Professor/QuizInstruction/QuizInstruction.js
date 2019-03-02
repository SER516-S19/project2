import React, { Component } from 'react';
import './QuizInstruction.css';
import { Redirect } from 'react-router-dom';
import { Container, Row, Col, Label, Button } from 'reactstrap';
import Routes from '../../../Routes';

class QuizInstruction extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      instruction: '',
      shouldShuffle: false,
      quizType: 'default',
      assignmentGroup: 'default',
      toCreateQuiz: false
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleNext = this.handleNext.bind(this);

  }

  handleChange(event) {
    const target = event.target;
    const value = target.type === 'checkbox' ? target.checked : target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }

  handleNext(event) {
    this.setState({ toCreateQuiz: true });
  }

  render() {
    return (
      <div>
        {
          (this.state.toCreateQuiz) ?
            <div>
              <Routes />
              <Redirect to={{
                pathname: '/createQuiz',
                state: { data: this.state }
              }} />
            </div>
            :
            <Container className="quizInstruction">
              <Row>
                <Col>
                  <input name="name" type="text" placeholder="Enter Quiz Title" 
                    onChange={this.handleChange} />
                </Col>
              </Row>
              <Row>
                <Col className="padding"> Quiz Instruction: </Col>
              </Row>
              <Row>
                <Col >
                  <textarea className="descriptionTextArea" placeholder="Enter description here ..."
                    name="instruction" type="text" onChange={this.handleChange} />
                </Col>
              </Row>
              <Row>
                <Col className="padding"></Col>
              </Row>
              <Row >
                <Col className="rightAlign">
                  <Label > Choose quiz type:</Label>
                </Col>
                <Col className="leftAlign" xs>
                  <select name="quizType"  onChange={this.handleChange}>
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
                  <select name="assignmentGroup"  onChange={this.handleChange}>
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
                <Button onClick={this.handleNext}> Next </Button>
              </Row>
            </Container>
        }
      </div>

    )
  }

}
QuizInstruction.propTypes = {
}

export default QuizInstruction;