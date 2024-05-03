import axios from "axios";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";

function SignUp() {

  const navigate = useNavigate();

  const [formData, setFormData] = useState({
    first_name: '',
    last_name: '',
    email: '',
    phone_number: '',
    password: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  }

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      let response = await axios.post('https://studentrenderapi.onrender.com/user/signup', formData);
      alert('Data Added Successfully ');
      console.log(response);
      navigate('/login');

    } catch (error) {
      console.log("Error On Sending Data", error
      )
    }
  }

  return (
    <>
      {/*  Navbar  */}
      <header className="header">
        <nav className="navbar navbar-expand-lg navbar-light py-3">
          <div className="container-fluid">
            <div className="text-white fw-bold fs-3 ">Unnanban</div>
          </div>
        </nav>
      </header>

      <div className="container">
        <div className="row py-4 mt-4 align-items-center">
          {/*  Simple Image  */}
          <div className="col-md-5 pr-lg-5 mb-5 mb-md-0">
            <img
              src="https://bootstrapious.com/i/snippets/sn-registeration/illustration.svg"
              alt=""
              className="img-fluid mb-3 d-md-block"
            />
            <h1 className="text-center">Create an Account</h1>
          </div>

          {/*  Registeration Form  */}
          <div className="col-md-7 col-lg-6 ml-auto">
            <form method="post" onSubmit={handleSubmit}>
              <div className="row">
                {/*  First Name  */}
                <div className="input-group col-lg-6 mb-4">
                  <div className="input-group-prepend">
                    <span className="input-group-text bg-white px-4 border-md border-right-0">
                      <i className="fa fa-user text-muted"></i>
                    </span>
                  </div>
                  <input
                    id="firstName"
                    type="text"
                    name="first_name"
                    autoComplete="off"
                    value={formData.first_name}
                    placeholder="First Name"
                    className="form-control bg-white border-left-0 border-md"
                    onChange={handleChange}
                  />
                </div>
                {/*  Last Name  */}
                <div className="input-group col-lg-6 mb-4">
                  <div className="input-group-prepend">
                    <span className="input-group-text bg-white px-4 border-md border-right-0">
                      <i className="fa fa-user text-muted"></i>
                    </span>
                  </div>
                  <input
                    id="lastName"
                    type="text"
                    name="last_name"
                    autoComplete="off"
                    value={formData.last_name}
                    placeholder="Last Name"
                    className="form-control bg-white border-left-0 border-md"
                    onChange={handleChange}
                  />
                </div>
                {/*  Email Address  */}
                <div className="input-group col-lg-12 mb-4">
                  <div className="input-group-prepend">
                    <span className="input-group-text bg-white px-4 border-md border-right-0">
                      <i className="fa fa-envelope text-muted"></i>
                    </span>
                  </div>
                  <input
                    id="email"
                    type="email"
                    name="email"
                    autoComplete="off"
                    value={formData.email}
                    placeholder="Email Address"
                    className="form-control bg-white border-left-0 border-lg"
                    onChange={handleChange}
                  />
                </div>
                {/*  Phone Number  */}
                <div className="input-group col-lg-12 mb-4">
                  <div className="input-group-prepend">
                    <span className="input-group-text bg-white px-4 border-md border-right-0">
                      <i className="fa fa-phone-square text-muted"></i>
                    </span>
                  </div>
                  <select
                    id="countryCode"
                    name="countryCode"
                    className="custom-select form-control bg-white border-left-0 border-md h-100 font-weight-bold text-muted"
                  >
                    <option value="">+91</option>
                  </select>
                  <input
                    id="phoneNumber"
                    type="tel"
                    name="phone_number"
                    autoComplete="off"
                    value={formData.phone_number}
                    placeholder="Phonenumber"
                    className="form-control bg-white border-md border-left-0 pl-3"
                    onChange={handleChange}
                  />
                </div>
                {/*  Password  */}
                <div className="input-group col-lg-6 mb-4">
                  <div className="input-group-prepend">
                    <span className="input-group-text bg-white px-4 border-md border-right-0">
                      <i className="fa fa-lock text-muted"></i>
                    </span>
                  </div>
                  <input
                    id="password"
                    type="password"
                    name="password"
                    autoComplete="off"
                    value={formData.password}
                    placeholder="Password"
                    className="form-control bg-white border-left-0 border-md"
                    onChange={handleChange}
                  />
                </div>
                {/*  Submit Button */}
                <div className="form-group text-center col-lg-12 mx-auto mb-0">
                  <button className="btn btn-primary btn-block py-2">
                    <span className="font-weight-bold">Create your account</span>
                  </button>
                </div>
                {/*  Divider Text  */}
                <div className="form-group col-lg-12 mx-auto d-flex align-items-center my-4">
                  <div className="border-bottom w-100 ml-5"></div>
                  <span className="px-2 small text-muted font-weight-bold text-muted">
                    OR
                  </span>
                  <div className="border-bottom w-100 mr-5"></div>
                </div>
                {/*  Already Registered  */}
                <div className="text-center w-100 mt-3">
                  <p className="text-muted font-weight-bold">
                    Already Registered?{" "}
                    <Link to='/login' className="text-secondary ml-2">
                      Login
                    </Link>
                  </p>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>

    </>
  );
}

export default SignUp;