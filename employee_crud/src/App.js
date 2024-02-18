import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import MainNavBar from './components/MainNavbar.jsx';
import LandingPage from './components/LandingPage';
import AddEmployeeForm from './components/AddEmployeeForm';
import EmployeeList from './components/EmployeeList.jsx';
import UpdateEmployeeForm from './components/UpdateEmployeeForm';

function App() {
  return (
    <Router>
    <div>
    <MainNavBar />
    <Routes>
      
      <Route path="/" exact element={<LandingPage/>} />
      <Route path="/add" element={<AddEmployeeForm/>} />
      <Route path="/employees" element={<EmployeeList/>} />
      <Route path="/update/:id" element={<UpdateEmployeeForm/>} />
      </Routes>
    </div>
  </Router>
  );
}

export default App;
