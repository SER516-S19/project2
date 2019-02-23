import React from 'react';
import { NavLink } from 'react-router-dom';

/**+
 *
 * @returns {*}
 * @constructor The main NavBar Class
 */
const Navigation = () => (
    <nav>
        <ul>
            {/*<li><NavLink exact activeClassName="current" to='/takeQuiz'>TakeQuiz</NavLink></li>*/}
            <li><NavLink exact activeClassName="current" to='/home'>Home</NavLink></li>
            {/*<li><NavLink exact activeClassName="current" to='/login'>Login</NavLink></li>*/}
        </ul>
    </nav>
);

export default Navigation;