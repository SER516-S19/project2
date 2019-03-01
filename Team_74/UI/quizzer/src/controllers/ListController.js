import * as helpers from "../helpers/arrayHelpers";
import axios from 'axios';

export default class ListController {
  constructor( array, callback) {
    this.array = array;
    this.callback = callback;
  }

  set(index, newContent) {
    this.callback(helpers.set(this.array, index, newContent));
  }

  setInstructions(details){
    this.details = details;
    console.log(details);
  }

  add(newContent) {
    this.callback([...this.array, newContent]);
  }

  remove(index) {
    this.callback(helpers.remove(this.array, index));
  }

  moveUp(index) {
    let newIndex = index === 0 ? index : index - 1;
    this.callback(helpers.move(this.array, index, newIndex));
  }

  moveDown(index) {
    let newIndex = index === this.array.length - 1 ? index : index + 1;
    this.callback(helpers.move(this.array, index, newIndex));
  }

  submit() {
    let questions = this.array;
    let details = this.details;
    let combined = { questions, ...details };
    console.log(combined);

    // axios.post(`https://localhost:8080/quiz`,
    //   { questions })
    //   .then(res => {
    //     console.log(res);
    //     console.log(res.data);
    //   })
  }


}