import React, { useState } from 'react';

function Register() {
  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: '',
    street: '',
    city: '',
    state: '',
    country: '',
    zipCode: ''
  });

  const handleChange = e => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = e => {
    e.preventDefault();
    console.log(formData);
  };

  const handleReset = () => {
    setFormData({
      username: '',
      email: '',
      password: '',
      street: '',
      city: '',
      state: '',
      country: '',
      zipCode: ''
    });
  };

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card">
            <div className="card-header bg-primary text-white">
              <h2 className="card-title mb-0">Registration Form</h2>
            </div>
            <div className="card-body">
              <form onSubmit={handleSubmit} onReset={handleReset}>
                <div className="mb-3">
                  <label htmlFor="username" className="form-label">Username</label>
                  <input type="text" className="form-control" id="username" name="username" value={formData.username} onChange={handleChange} />
                </div>
                <div className="mb-3">
                  <label htmlFor="email" className="form-label">Email</label>
                  <input type="email" className="form-control" id="email" name="email" value={formData.email} onChange={handleChange} />
                </div>
                <div className="mb-3">
                  <label htmlFor="password" className="form-label">Password</label>
                  <input type="password" className="form-control" id="password" name="password" value={formData.password} onChange={handleChange} />
                </div>
                <div className="mb-3">
                  <label htmlFor="street" className="form-label">Street</label>
                  <input type="text" className="form-control" id="street" name="street" value={formData.street} onChange={handleChange} />
                </div>
                <div className="mb-3">
                  <label htmlFor="city" className="form-label">City</label>
                  <input type="text" className="form-control" id="city" name="city" value={formData.city} onChange={handleChange} />
                </div>
                <div className="mb-3">
                  <label htmlFor="state" className="form-label">State</label>
                  <input type="text" className="form-control" id="state" name="state" value={formData.state} onChange={handleChange} />
                </div>
                <div className="mb-3">
                  <label htmlFor="country" className="form-label">Country</label>
                  <input type="text" className="form-control" id="country" name="country" value={formData.country} onChange={handleChange} />
                </div>
                <div className="mb-3">
                  <label htmlFor="zipCode" className="form-label">Zip Code</label>
                  <input type="text" className="form-control" id="zipCode" name="zipCode" value={formData.zipCode} onChange={handleChange} />
                </div>
                <div className="d-grid gap-2">
                  <button type="submit" className="btn btn-primary">Submit</button>
                  <button type="reset" className="btn btn-secondary">Reset</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Register;
