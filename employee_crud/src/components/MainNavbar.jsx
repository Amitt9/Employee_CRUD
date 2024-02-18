import React from 'react';
import { Link } from 'react-router-dom';
import './componentcss/navBar.css';

function MainNavBar() {
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary">
  <div className="container-fluid">
    <a className="navbar-brand" href="#">
     Cubics Software
    </a>
  
    <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div className="navbar-nav">
        <a className="home" aria-current="page" href="/">
          Home
        </a>
       
        <a className="nav-link" href="/employees">
          Employee List
        </a>
        <a className="nav-link" href="/add">
          Add Employee
        </a>
        {/* <a className="updateEmployee" href="/update/:id" >
          Update Employee
        </a> */}
      </div>
    </div>
  </div>
</nav>

  );
}

export default MainNavBar;
