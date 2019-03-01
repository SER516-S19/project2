import React from 'react'

import './Toolbar.css'

const Toolbar = props => (
  <header className="toolbar">
    <nav className="toolbar__navigation">
      <div />
      <div className="toolbar__logo">
        <a href="/">THE BLACKBORD</a>
      </div>
      <div className="space"></div>
      <div className="toolbar__logo">
      <a href="/home">{props.title}</a>
      </div>

      <div className="spacer" />
      <div className="toolbar_navigation-items">
        <ul>
          <li>
            <a href="/home">Home</a>
          </li>
          <li>
            <a href="/dash">Dashboard</a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
)

export default Toolbar