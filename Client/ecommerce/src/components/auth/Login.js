import React, { useState } from 'react';


function Login() {
  const [formData, setFormData] = useState({
    email: '',
    password: ''
  });

  const handleChange = e => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = e => {
    e.preventDefault();
    console.log(formData);
  };

  const handleForgotPassword = () => {
    console.log("Forgot Password clicked!");
    // Implement the functionality to handle forgot password
  };

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card">
            <div className="card-header bg-primary text-white">
              <h2 className="card-title mb-0">Sign In</h2>
            </div>
            <div className="card-body">
              <form onSubmit={handleSubmit}>
                <div className="mb-3">
                  <label htmlFor="email" className="form-label">Email</label>
                  <input type="email" className="form-control" id="email" name="email" value={formData.email} onChange={handleChange} />
                </div>
                <div className="mb-3">
                  <label htmlFor="password" className="form-label">Password</label>
                  <input type="password" className="form-control" id="password" name="password" value={formData.password} onChange={handleChange} />
                </div>
                <div className="d-grid gap-2">
                  <button type="submit" className="btn btn-primary">Sign In</button>
                  <a href="#" className="btn btn-link" onClick={handleForgotPassword}>Forgot Password?</a>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;
