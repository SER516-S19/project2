import React from 'react';
import PropTypes from 'prop-types';
import Question from '../components/Question';
import QuestionCount from './QuestionCount';
import AnswerOption from '../components/AnswerOption';
import { CSSTransitionGroup } from 'react-transition-group';


function Quiz(props) {

    function renderAnswerOptions(key) {
        // console.log(key);
        return (
            <AnswerOption
                key={key}
                answerContent={key}
                answerType={key}
                answer={props.answer}
                // questionId={props.questionId}
                onAnswerSelected={props.onAnswerSelected}
            />
        );
    }
    return (
        <CSSTransitionGroup
            className="container"
            component="div"
            transitionName="fade"
            transitionEnterTimeout={800}
            transitionLeaveTimeout={500}
            transitionAppear
            transitionAppearTimeout={500}
        >
            <div key={props.questionId}>
                <QuestionCount
                    counter={props.questionSerial}
                    total={props.questionTotal}
                />
                <Question content={props.question} />
                <ul className="answerOptions">
                    {props.answerOptions.map(renderAnswerOptions)}
                </ul>

            </div>
        </CSSTransitionGroup>
    );
}

Quiz.propTypes = {
    answer: PropTypes.string,
    answerOptions: PropTypes.array.isRequired,
    counter: PropTypes.number,
    question: PropTypes.string.isRequired,
    questionId: PropTypes.any.isRequired,
    questionSerial: PropTypes.number.isRequired,
    questionTotal: PropTypes.number.isRequired,
    onAnswerSelected: PropTypes.func.isRequired,

};

export default Quiz;