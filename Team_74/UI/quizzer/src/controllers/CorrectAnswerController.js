export default class CorrectAnswerController {
    constructor( question, callback) {
      this.question = question;
      this.callback = callback;
    }
  
    setCorrectAnswer(correctAnswer){
      this.question["correctAnswer"] = correctAnswer;
    }
  }