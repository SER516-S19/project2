import React, { Component } from 'react';
import './TakeQuiz.css';
import Result from '../../../components/Result';
import Quiz from '../../../components/Quiz';
import Timer from "react-compound-timer";
import axios from "axios";


class TakeQuiz extends Component {
    /**Constructor for the main TakeQuiz Class*/
    constructor(props) {
        super(props);
        console.log(props);
        this.state = {
            quiz: null,
            quizInstructions:'',
            quizQuestions:[],
            counter: 0,
            questionId: 1,
            questionSerial: 1,
            questionText: '',
            answerOptions: [],
            answer: '',
            answersCount: {
                A: 0,
                B: 0,
                C: 0,
                D: 0
            },
            correctAnswer:'',
            point:0,
            totalPoints:0,
            totalMarks:0,
            totalTime:1000,
            response:'',
            result: ''
        };
        this.handleAnswerSelected = this.handleAnswerSelected.bind(this);
        this.setPreviousQuestion = this.setPreviousQuestion.bind(this);
        this.submitQuiz = this.submitQuiz.bind(this);
    }

    /**
     * componentWillMount life cycle event is invoked once,
     * both on the client and server, immediately before the initial rendering occurs*/

     
    componentWillMount() {
        axios.get("http://localhost:8081/prof/quiz/"+this.props.quizId)
            .then(response => {
                this.setState({
                    quiz: response.data.response,
                    quizId: response.data.response.id,
                    quizInstructions: response.data.response.instruction,
                    quizQuestions: response.data.response.questions,
                    totalMarks: response.data.response.totalMarks,
                    totalTime: response.data.response.time * 60 * 1000

                });
                const shuffledAnswerOptions = this.state.quizQuestions.map((question) => this.shuffleArray(question.options));
                this.setState({
                    questionId: this.state.quizQuestions[0].id,
                    questionText: this.state.quizQuestions[0].questionText,
                    point: this.state.quizQuestions[0].marks,
                    correctAnswer: this.state.quizQuestions[0].correctAnswer,
                    answerOptions: shuffledAnswerOptions[0]
            });
                console.log(this.state.totalTime);
                localStorage.setItem('Time',this.state.totalTime);
        })
        console.log(this.state.point);
    }

    submitQuiz() {
        this.sendResults();
        setTimeout(() => this.setResults(this.getResults()), 300);
    }

    /**
     * shuffleArray would randomise the order of questions*/
    shuffleArray(array) {
        var currentIndex = array.length, temporaryValue, randomIndex; 
        while (0 !== currentIndex) {
            // Pick a remaining element...
            randomIndex = Math.floor(Math.random() * currentIndex);
            currentIndex -= 1;
            // And swap it with the current element.
            temporaryValue = array[currentIndex];
            array[currentIndex] = array[randomIndex];
            array[randomIndex] = temporaryValue;
        }
        return array;
    };

    setUserAnswer(answer) {
        console.log("Here")
        this.setState((state) => ({
            answersCount: {
                ...state.answersCount,
                [answer]: state.answersCount[answer] + 1
            },
            answer: answer,
            totalPoints: (answer.toString().localeCompare(this.state.correctAnswer) === 0) ? state.totalPoints + state.point: state.totalPoints
        }));

        console.log(answer)
        console.log(this.state.totalPoints);
    }

    setNextQuestion() {
        const counter = this.state.counter + 1;
        const questionSerial = this.state.questionSerial + 1;
        this.setState({
            counter: counter,
            questionId: this.state.quizQuestions[counter].id,
            questionSerial: questionSerial,
            questionText: this.state.quizQuestions[counter].questionText,
            answerOptions: this.state.quizQuestions[counter].options,
            answer: '',
            correctAnswer: this.state.quizQuestions[counter].correctAnswer,
            point: this.state.quizQuestions[counter].marks
        });
    }

    setPreviousQuestion() {
        console.log(this.state.counter); 
        if(this.state.questionSerial > 1) {
            const counter = this.state.counter - 1;
            const questionSerial = this.state.questionSerial - 1;
            this.setState({
                counter: counter,
                questionId: this.state.quizQuestions[counter].id,
                questionSerial: questionSerial,
                questionText: this.state.quizQuestions[counter].questionText,
                answerOptions: this.state.quizQuestions[counter].options,
                answer: '',
                correctAnswer: this.state.quizQuestions[counter].correctAnswer,
                point:this.state.quizQuestions[counter].marks
            });
        }
    }

    sendResults() {

        console.log(this.state.quiz,this.state.quizId,this.state.totalPoints)
        axios.post("http://localhost:8081/results",{
            studentId: localStorage.getItem('username'),
            quiz: this.state.quiz,
            quizId: this.state.quizId,
            marksAchieved: this.state.totalPoints
        }).then(response =>{
            console.log(response);
        })

    }
    
    getResults() {
        const answersCount = this.state.answersCount;
        const answersCountKeys = Object.keys(answersCount);
        const answersCountValues = answersCountKeys.map((key) => answersCount[key]);
        const maxAnswerCount = Math.max.apply(null, answersCountValues);
        return answersCountKeys.filter((key) => answersCount[key] === maxAnswerCount);
    }

    setResults (result) {
        console.log(this.state.answer);
        localStorage.removeItem('Time');
        if (result.length === 1) {
            this.setState({ result: result[0] });
        } else {
            this.setState({ result: this.state.totalPoints+ " out of "+this.state.totalMarks });
        }
    }

    /**
     *handleAnswerSelected function performs two tasks: setting the answer and then setting the next question*/
    handleAnswerSelected(event) {
        this.setUserAnswer(event.currentTarget.value);
        if (this.state.questionSerial < this.state.quizQuestions.length) {
            setTimeout(() => this.setNextQuestion(), 300);
        } else {
            this.sendResults();
            setTimeout(() => this.setResults(this.getResults()), 300);
        }
    }

    renderQuiz() {
        return (
            <div>
                <div className="Timer">
                    <Timer
                        checkpoints={[
                            {
                                time: 60000,
                                callback: () => {
                                    alert ("Half-Time over Warning Message!! Quiz will submit automatically on time completion");
                                }
                            },{
                                time: 120000,
                                callback: () => {
                                    this.submitQuiz();
                                }
                            }
                        ]}
                    >
                        {() => (
                            <React.Fragment>
                                <Timer.Minutes /> minutes <span></span> <span></span>
                                <Timer.Seconds /> seconds
                            </React.Fragment>
                        )}
                    </Timer>
                </div>
            <Quiz
                answer={this.state.answer}
                answerOptions={this.state.answerOptions}
                questionId={this.state.questionId}
                questionSerial={this.state.questionSerial}
                question={this.state.questionText}
                questionTotal={this.state.quizQuestions.length}
                onAnswerSelected={this.handleAnswerSelected}
            />
                <button type="back" className="previous-question" onClick={this.setPreviousQuestion}>&laquo;Back</button>
                <button type="submit" className="submit-quiz" onClick={this.submitQuiz}>Submit</button>
            </div>

        );
    }

    renderResult() {
        return <div>
                <Timer className="TakeQuiz-timer">
                    {({ start, resume, pause, stop, timerState }) => (
                        <div>{stop}</div>
                    )}
                </Timer>
                <Result quizResult={this.state.result} />
                </div>;
    }

    render() {
        return (
            <div className="TakeQuiz">
                <div className="TakeQuiz-header">
                    <h2>Demo Quiz</h2>
                    <h5>Instructions: {this.state.quizInstructions}</h5>
                </div>
                {this.state.result ? this.renderResult()
                    :

                    this.renderQuiz()
                }
            </div>
        );
    }


}

export default TakeQuiz;