import React from 'react';
import { Switch, Route } from 'react-router-dom';
import Home from './pages/Home/Home'
// import Login from './pages/Login/Login';
import TakeQuiz from './pages/Student/TakeQuiz/TakeQuiz'
//import Login from './pages/Login/Login';
//import TakeQuiz from './pages/TakeQuiz/TakeQuiz'
import QuizBuilder from './components/professor/QuizBuilder';
import './index.css';
import Dashboard from './components/Dashboard/Dashboard';
import LoginApp from './components/NewLogin/LoginApp';
import App from './App';

/**+
 *
 * @returns {*}
 * @constructor: The Main Router Class
 */
const Routes = () => (
    <main className="main">
    <Switch>
        {/* <Route exact path='/' component={Login}></Route> */}
        <Route exact path='/' component={App}></Route>
        <Route exact path='/home' component={Home}></Route>
        <Route exact path='/dash' component={Dashboard}></Route>
        {/* <Route exact path='/login' component={Login}></Route> */}
        <Route exact path='/login' component={LoginApp}></Route>
        <Route exact path='/takeQuiz' component={TakeQuiz}></Route>
        <Route exact path='/createQuiz' component={QuizBuilder}></Route>
    </Switch>
    </main>
);

export default Routes;