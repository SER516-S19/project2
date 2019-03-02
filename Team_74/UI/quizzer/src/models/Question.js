export default class Question {
    // static TYPES = Object.freeze({
    //   SINGLE: "Options: Pick One",
    //   MULTIPLE: "Options: Pick Any Number",
    //   TEXT: "Short Answer"
    // });
    static TYPES = Object.freeze({
      SINGLE: "Options: Pick One"
    });
  
    static DEFAULTS = Object.freeze({
      questionText: "New Question",
      type: Question.TYPES.SINGLE,
      options: []
    });
  
    constructor(params = {}) {
      const { questionText, type, options, marks, id } = { ...Question.DEFAULTS, ...params };
      this.questionText = questionText;
      this.type = type;
      this.marks = marks;
      this.options = options;
      this.id = id || Math.random();
    }
  
    get hasOptions() {
      // return (
      //   this.type === Question.TYPES.SINGLE ||
      //   this.type === Question.TYPES.MULTIPLE
      // );
      return (
        this.type === Question.TYPES.SINGLE 
      );
    }
  
    get inputType() {
      if (this.type === Question.TYPES.SINGLE) return "radio";
      //if (this.type === Question.TYPES.MULTIPLE) return "checkbox";
      //throw new Error("This question does not have an input type.");
    }
  
    merge(patch) {
      return new Question({ ...this, ...patch });
    }
  }
  