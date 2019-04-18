import React, {Component} from 'react';
import styled from 'styled-components';
import axios from "axios";

const Wrapper = styled.div`
    position: relative;
`;

const LinkWrapper = styled.div`
    position: relative;
    text-align: right;
`;

const Link = styled.a`
    font-size: 20px;
    text-decoration: underline;
    color: #5f8420;
    &:hover {
        color: #5f8420;
    }    
`;

class Login extends Component {

    constructor(props) {
        super(props);

        this.state = {
            user: {},
            email: ''
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({email: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();

        axios.get("http://localhost:2030/api/users/email/" + this.state.email).then(res => {
            const user = res.data;
            this.setState({user});
        });
    }

    render() {
        const {user} = this.state;
        return (
            <Wrapper>
                <LinkWrapper>
                    <Link href="" data-toggle="modal" data-target="#loginModalCenter">Login</Link>
                </LinkWrapper>

                <div className="modal fade" id="loginModalCenter" tabIndex="-1" role="dialog"
                     aria-labelledby="loginModalCenterTitle" aria-hidden="true">
                    <div className="modal-dialog modal-dialog-centered" role="document">
                        <div className="modal-content">
                            <div className="modal-header">
                                <h5 className="modal-title" id="loginModalLongTitle">Login</h5>
                                <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div className="modal-body">
                                <form className="needs-validation">
                                    <div className="form-group">
                                        <label htmlFor="userInputEmail1">Email</label>
                                        <input type="email" className="form-control" id="userInputEmail1"
                                               aria-describedby="emailHelp" placeholder="Enter email"
                                               value={this.state.email}
                                               onChange={this.handleChange} required/>
                                        <small id="emailHelp" className="form-text text-muted">We'll never share
                                            your email with anyone else.
                                        </small>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="userInputPassword">Password</label>
                                        <input type="password" className="form-control" id="userInputPassword"
                                               placeholder="Password" required/>
                                    </div>
                                    <button onSubmit={this.handleSubmit} type="submit"
                                            className="btn btn-primary">Submit
                                    </button>
                                    <p>{user.id} {user.name} {user.email}</p>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </Wrapper>
        )
    }
}

export default Login;