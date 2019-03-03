import React from 'react';
import { Route, Switch } from 'react-router-dom';
import App from './App';
import LoginApp from './components/NewLogin/LoginApp';
import QuizBuilder from './components/professor/QuizBuilder';
import './index.css';
import Home from './pages/Home/Home';
import TakeQuiz from './pages/Student/TakeQuiz/TakeQuiz';

/**+
 *
 * @returns {*}
 * @constructor: The Main Router Class
 */
const Routes = () => (
    <main className="main">
        <Switch>
            <Route exact path='/' component={App}></Route>
            <Route exact path='/home' component={Home}></Route>
            <Route exact path='/login' component={LoginApp}></Route>
            <Route exact path='/takeQuiz' component={TakeQuiz}></Route>
            <Route exact path='/createQuiz' component={QuizBuilder}></Route>
        </Switch>
    </main>
);

export default Routes;