import React, { useState } from 'react'
import { Link, useNavigate } from "react-router-dom"
import axios from 'axios'
import useSignIn from 'react-auth-kit/hooks/useSignIn';

function SignIn() {

    const navigate = useNavigate()
    const signIn = useSignIn();

    const [formData, setFormData] = useState({
        email: '',
        password: ''
    })

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    }

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log(formData)
        try {
            let response = await axios.post('https://studentrenderapi.onrender.com/user/login', formData);
            const token = response.data[0].token
            if (signIn({
                auth: {
                    token: token,
                    type: 'Bearer',
                    expiresIn: 86000
                }
            })) {
                // Redirect or do-something  
                alert("Succesfully Logged In ");
                setTimeout(navigate(-1), 3000);
            }
        } catch (error) {
            console.log("Error On Sending Data", error)
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
            {/* End of Navbar */}
            {/* --------------------- */}
            {/* Start of Sigin Page */}
            <div className="container">
                <div className="row py-4 mt-4 align-items-center justifly-content-center">
                    {/*  Simple Image  */}
                    <div className="col-md-5 pr-lg-5 mb-5 mb-md-0">
                        <img
                            src="https://bootstrapious.com/i/snippets/sn-registeration/illustration.svg"
                            alt=""
                            className="img-fluid mb-3  d-md-block"
                        />
                        <h1 className="text-center"> Sign In </h1>
                    </div>

                    {/* Sign In */}
                    <div className="col-md-7 col-lg-6 ml-auto">
                        <form onSubmit={handleSubmit}>
                            <div className='row '>
                                {/* Email / Username */}
                                <div className="input-group col-lg-6 mb-4">
                                    <div className="input-group-prepend">
                                        <span className="input-group-text bg-white px-4 border-md border-right-0">
                                            <i className="fa-regular fa-envelope text-muted"></i>
                                        </span>
                                    </div>
                                    <input
                                        id="email"
                                        type="email"
                                        name="email"
                                        autoComplete="off"
                                        value={formData.email}
                                        placeholder="E-Mail"
                                        className="form-control bg-white border-left-0 border-md"
                                        onChange={handleChange}
                                    />
                                </div>
                                {/* Password  */}
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
                                        placeholder="Password"
                                        value={formData.password}
                                        className="form-control bg-white border-left-0 border-md"
                                        onChange={handleChange}
                                    />
                                </div>
                                {/*  Submit Button */}
                                <div className="form-group text-center col-lg-12 mx-auto mb-0">
                                    <button type='submit' className="btn btn-primary btn-block py-2">
                                        <span className="font-weight-bold">Login</span>
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
                                {/*  New Registered  */}
                                <div className="text-center w-100 mt-3">
                                    <p className="text-muted font-weight-bold">
                                        Not a Member?{" "}
                                        <Link to='/signup' className="text-secondary ml-2">
                                            Sign Up
                                        </Link>
                                    </p>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </>
    )
}

export default SignIn