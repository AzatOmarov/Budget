import React, {Component} from 'react';
import styled from 'styled-components';

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
    render() {
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
                                               aria-describedby="emailHelp" placeholder="Enter email" required/>
                                        <small id="emailHelp" className="form-text text-muted">We'll never share
                                            your email with anyone else.
                                        </small>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="userInputPassword">Password</label>
                                        <input type="password" className="form-control" id="userInputPassword"
                                               placeholder="Password" required/>
                                    </div>
                                    <button type="submit" className="btn btn-primary">Submit</button>
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