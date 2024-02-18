import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';
import './componentcss/form.css'

function UpdateEmployeeForm() {
  const [employee, setEmployee] = useState({});
  const { id } = useParams();
 const navigate = useNavigate();
 const [formData, setFormData] = useState({
  firstName: '',
  lastName: '',
  email: '',
  department: '',
  position: ''
});

  useEffect(() => {
    console.log(id);
    fetchEmployee();
  }, []);

  const fetchEmployee = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/employees/${id}`);
      console.log(response.data);
      setEmployee(response.data);
      setFormData(response.data);
    } catch (error) {
      console.error('Error fetching employee:', error);
    }
  };

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.put(`http://localhost:8080/employees/${id}`, formData);
      alert("Employee Details Updated successfully");
      navigate('/employees');
    } catch (error) {
      console.error('Error updating employee:', error);
    }
  };

  return (
    <div className="form-container">
      <h2>Update Employee</h2>
      <form onSubmit={handleSubmit}>
        <input type="text" name="firstName"  value={formData.firstName } onChange={handleChange} />
        <input type="text" name="lastName"  value={formData.lastName} onChange={handleChange} />
        <input type="email" name="email"  value={formData.email } onChange={handleChange} />
        <input type="text" name="department" value={formData.department } onChange={handleChange} />
        <input type="text" name="position"  value={formData.position} onChange={handleChange} />
        <button type="submit">Update Employee</button>
      </form>
    </div>
  );
}

export default UpdateEmployeeForm;
