import React, { Component } from 'react';
import './TakeQuiz.css';
import Result from '../../components/Result';
// import quizQuestions from '../../api/quizQuestions';
import Quiz from '../../components/Quiz';
import Timer from "react-compound-timer";
import axios from "axios";


class TakeQuiz extends Component {

    /**Constructor for the main TakeQuiz Class*/
    constructor(props) {
        super(props);
        this.state = {
            quizInstructions:'',
            quizQuestions:[],
            counter: 0,
            questionId: 1,
            questionSerial: 1,
            questionText: '',
            answerOptions: [],
            answer: '',
            answersCount: {
                nintendo: 0,
                microsoft: 0,
                sony: 0
            },
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
        const params = new URLSearchParams(this.props.location.search);
        axios.get("http://localhost:8081/prof/quiz/"+params.get('quizId'))
            .then(response => {
                this.setState({
                    quizInstructions: response.data.response.instruction,
                    quizQuestions: response.data.response.questions
                });
                const shuffledAnswerOptions = this.state.quizQuestions.map((question) => this.shuffleArray(question.options));
                this.setState({
                    questionText: this.state.quizQuestions[0].questionText,
                    answerOptions: shuffledAnswerOptions[0]
            });
        })

        console.log(params.get('quizId'));
    }

    submitQuiz() {
        setTimeout(() => this.setResults(this.getResults()), 300);
    }

    /**+
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
        this.setState((state) => ({
            answersCount: {
                ...state.answersCount,
                [answer]: state.answersCount[answer] + 1
            },
            answer: answer
        }));

        console.log(answer);
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
            answer: ''
        });
    }

    setPreviousQuestion() {

        console.log(this.state.counter);
        // this.setUserAnswer(event.currentTarget.value);

        if(this.state.questionSerial > 1) {
            const counter = this.state.counter - 1;
            const questionSerial = this.state.questionSerial - 1;
            this.setState({
                counter: counter,
                questionId: this.state.quizQuestions[counter].id,
                questionSerial: questionSerial,
                questionText: this.state.quizQuestions[counter].questionText,
                answerOptions: this.state.quizQuestions[counter].options,
                answer: ''
            });
        }
    }
    getResults() {
        const answersCount = this.state.answersCount;
        const answersCountKeys = Object.keys(answersCount);
        const answersCountValues = answersCountKeys.map((key) => answersCount[key]);
        const maxAnswerCount = Math.max.apply(null, answersCountValues);
        return answersCountKeys.filter((key) => answersCount[key] === maxAnswerCount);
    }

    setResults (result) {
        if (result.length === 1) {
            this.setState({ result: result[0] });
        } else {
            this.setState({ result: 'Undetermined' });
        }
    }

    /**+
     *handleAnswerSelected function performs two tasks: setting the answer and then setting the next question*/

    handleAnswerSelected(event) {
        this.setUserAnswer(event.currentTarget.value);
        if (this.state.questionSerial < this.state.quizQuestions.length) {
            setTimeout(() => this.setNextQuestion(), 300);
        } else {
            setTimeout(() => this.setResults(this.getResults()), 300);
        }
    }

    renderQuiz() {
        return (
            <div>
                <div className="Timer">
                <Timer >
                    {/*<Timer.Days /> days*/}
                    {/*<Timer.Hours /> hours*/}
                    <Timer.Minutes /> minutes <span></span> <span></span>
                    <Timer.Seconds /> seconds
                    {/*<Timer.Milliseconds /> milliseconds*/}
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
                    {({ start, resume, pause, stop,timerState }) => (
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
