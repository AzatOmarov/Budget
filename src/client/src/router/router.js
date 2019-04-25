import React, {Component} from 'react';
import {BrowserRouter as Router, Link, Redirect, Route, Switch, withRouter} from 'react-router-dom';

import {connect} from 'react-redux';
import {axiosUserAction} from '../store/actions/user-actions.js';
import axios from 'axios';

import App from '../components/containers/app/App.js';
import Transactions from '../components/containers/transactions/Transactions.js';
import Settings from '../components/containers/settings/Settings.js';
import Profile from '../components/containers/profile/Profile.js';

class Login extends Component {

    constructor(props) {
        super(props);
        this.state = {
            email: '',
            redirectToReferrer: false
        };

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({email: event.target.value});
    };

    getUserByEmail() {
        axios.get("http://localhost:2030/api/users/email/" + this.state.email).then(res => {
            const user = res.data;
        this.props.axiosUser(user);
        });
    }

    login = () => {
        fakeAuth.authenticate(() => {
            this.setState({redirectToReferrer: true});
        });
    };

    handleSubmit(event) {
        event.preventDefault();
        this.getUserByEmail();
        this.login();
    }

    render() {
        let {from} = this.props.location.state || {from: {pathname: "/settings/wallet"}};
        let {redirectToReferrer} = this.state;

        if (redirectToReferrer) return <Redirect to={from}/>;

        return (
            <div className="frame-small">
                <div className="login">
                    <p>You must log in to view more information</p>
                    <form className="needs-validation" onSubmit={this.handleSubmit}>
                        <div className="form-group">
                            <label htmlFor="userInputEmail1">Email</label>
                            <input type="email"
                                   className="form-control"
                                   id="userInputEmail1"
                                   aria-describedby="emailHelp"
                                   placeholder="Enter email"
                                   value={this.state.email}
                                   onChange={this.handleChange}
                                   required/>
                            <small id="emailHelp" className="form-text text-muted">
                                We'll never share your email with anyone else.
                            </small>
                        </div>
                        <div className="form-group">
                            <label htmlFor="userInputPassword">Password</label>
                            <input type="password" className="form-control" id="userInputPassword"
                                   placeholder="Password" required/>
                        </div>
                        <input className="btn btn-primary" type="submit" value="Log in"/>
                    </form>
                </div>
            </div>
        );
    }
}

const mapDispatchToProps = dispatch => {
    return {
        axiosUser: (user) => {
            dispatch(axiosUserAction(user))
        }
    }
};

const WrappedLogin = connect(null, mapDispatchToProps)(Login);


function Start(props) {
    return (
        <Router>
            <div className="container">
                <div className="row">
                    <div className="col-6"/>
                    <div className="col-6 auth">
                        <p>Hi, {props.user.id}</p>
                        <AuthButton/>
                        <Link to="/login">Login</Link>
                    </div>
                </div>
                <div className="row">
                    <div className="col-12">
                        <Switch>
                            <Route exact path="/" component={props=> <App {...props}/>}/>
                            <Route exact path="/login" component={props=> <WrappedLogin {...props}/>}/>
                            <Route exact path="/transactions" component={props=> <Transactions {...props}/>}/>
                            <Route exact path="/settings" component={props=> <Settings {...props}/>}/>
                            <Route exact path="/profile" component={props=> <Profile {...props}/>}/>
                            <Route exact to="/"/>
                        </Switch>
                    </div>
                </div>
            </div>
        </Router>
    );
}

const mapStateToProps = state => ({user: state.user});

const WrappedStart = connect(mapStateToProps)(Start);

const fakeAuth = {
    isAuthenticated: false,
    authenticate(cb) {
        this.isAuthenticated = true;
        setTimeout(cb, 100);
    },
    signout(cb) {
        this.isAuthenticated = false;
        setTimeout(cb, 100);
    }
};

const AuthButton = withRouter(
    ({history}) =>
        fakeAuth.isAuthenticated ? (
            <p>
                <a href="/"
                   onClick={() => {
                       fakeAuth.signout(() => history.push("/"));
                   }}
                >
                    Sign out
                </a>
            </p>
        ) : (
            <p>You are not logged in</p>
        )
);

function PrivateRoute({component: Component, ...rest}) {
    console.log(rest);
    return (
        <Route
            {...rest}
            render={props =>
                fakeAuth.isAuthenticated ? (
                    <Component {...props} />
                ) : (
                    <Redirect
                        to={{
                            pathname: "/login",
                            state: {from: props.location}
                        }}
                    />
                )
            }
        />
    );
}

export default WrappedStart;