import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from "axios";

class SignUpForm extends Component {
    constructor(props) {
        super(props);

        localStorage.clear();
        this.state = {
            email: '',
            password: '',
            firstName: '',
            lastName:'',
            role: 0,
            isStudent:false,
            isProfessor:false,
            hasAgreed: false,
            dob: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(e) {
        let target = e.target;

        // if(target.type === 'radio'){
        //     if(target.id === 'Professor')
        //         this.setState({ role: 1 });
        //     else if(target.id === 'Student')
        //         this.setState({ role: 0 });
        // }else {
            // if(){
            //     let value = target.
            // }
            let value = (target.type === 'checkbox') ? target.checked : target.value;
            let name = target.name;

            console.log(name, value);

            this.setState({
                [name]: value
            });

            // console.log(this.state.isProfessor);
            // if(this.state.isProfessor)
            //     this.setState({ role: 1 });
            // else
            //     this.setState({ role: 0 });
        //
        // console.log("Role", this.state.role);

        // }
    }

    handleSubmit(e) {
        e.preventDefault();

        // if(this.state.isPr)
        console.log(this.state.role);

        this.setState({ submitted: true });
        const { email, password,firstName,lastName,role, dob , hasAgreed } = this.state;

        // stop here if form is invalid
        if (!(hasAgreed)) {
            return;
        }

        this.setState({ loading: true });


        axios.post('http://localhost:8081/register', {
            firstName: firstName,
            userEmailId: email,
            lastName: lastName,
            role: role,
            userPassword: password


        })
            .then((response) => {
                    if (response.data.response != null) {
                        console.log(response);
                        // localStorage.setItem('firstName', firstName);
                        // localStorage.setItem('lastName', lastName);
                        localStorage.setItem('email', email);
                        // localStorage.setItem('password', password);
                        // localStorage.setItem('dob', dob);
                        localStorage.setItem('type', response.data.response.role);
                        const {from} = this.props.location.state || {from: {pathname: "/login"}};
                        this.props.history.push(from)
                    }else{
                        this.setState({ error: response.data.errorMessage , loading: false });
                        const {from} = this.props.location.state || {from: {pathname: "/signupform"}};
                        this.props.history.push(from)
                    }
                },
                error => this.setState({ error, loading: false })
            );
    }

       // console.log('The form was submitted with the following data:');
        //console.log(this.state);


    render() {
        //const { firstName, lastName, email, dob, password ,error } = this.state;

        return (
            <div className="FormCenter">
                <form onSubmit={this.handleSubmit} className="FormFields">
                    <div className="FormField">
                        <label className="FormField__Label" htmlFor="firstName">First Name</label>
                        <input type="text" id="firstName" className="FormField__Input" placeholder="First name" name="firstName" value={this.state.firstName} onChange={this.handleChange} />
                    </div>
                    <div className="FormField">
                        <label className="FormField__Label" htmlFor="lastName">Last Name</label>
                        <input type="text" id="lastName" className="FormField__Input" placeholder="Last name" name="lastName" value={this.state.lastName} onChange={this.handleChange} />
                    </div>

                    <div className="FormField">
                        <label className="FormField__Label" htmlFor="email">E-Mail Address</label>
                        <input type="email" id="email" className="FormField__Input" placeholder="Enter your email" name="email" value={this.state.email} onChange={this.handleChange} />
                    </div>
                    <div className="FormField">
                        <label className="FormField__Label" htmlFor="password">Password</label>
                        <input type="password" id="password" className="FormField__Input" placeholder="Enter your password" name="password" value={this.state.password} onChange={this.handleChange} />
                    </div>

                    <div className="FormField">
                        <label className="FormField__Label" htmlFor="dob">Date of Birth</label>
                        <input type="date" id="dob" className="FormField__Input" placeholder="Enter your Date of Birth" name="dob" value={this.state.dob} onChange={this.handleChange} />
                    </div>


                    <div className="FormRadioGroup">
                        <div className="FormRadioProfessor">
                            <label htmlFor="Professor">
                                <input type="radio" id="Professor" name="role" value={1} onChange={this.handleChange}/> Professor
                            </label>
                        </div>
                        <div className="FormRadioStudent">
                            <label htmlFor="Student">
                                <input type="radio" id="Student" name="role" value={0} onChange={this.handleChange}/> Student
                            </label>
                        </div>
                    </div>

                    <div className="FormField">
                        <button className="FormField_Button mr-20">Sign Up</button> <Link to="/login" className="FormField_Link">I'm already member</Link>
                    </div>

                    <div className="FormField">
                        <label className="FormField__CheckboxLabel">
                            <input className="FormField_Checkbox" type="checkbox" name="hasAgreed" value={this.state.hasAgreed} onChange={this.handleChange} /> I agree all statements in <a href="" className="FormField_TermsLink">terms of service</a>
                        </label>
                    </div>

                </form>
            </div>
        );
    }
}

export default SignUpForm;
