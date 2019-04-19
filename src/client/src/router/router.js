import React, {Component} from 'react';
import {
    BrowserRouter as Router,
    Route,
    Link,
    Redirect,
    withRouter
} from 'react-router-dom';

import App from '../components/containers/app/App.js';
import Transactions from '../components/containers/transactions/Transactions.js';
import Settings from '../components/containers/settings/Settings.js';
import Profile from '../components/containers/profile/Profile.js';
import axios from 'axios';

window.userId = '';

function Start() {
    return (
        <Router>
            <div className="container">
                <div className="row">
                    <div className="col-6"/>
                    <div className="col-6 auth">
                        <AuthButton/>
                        <Link to="/public">Demo</Link>&nbsp;&nbsp;
                        <Link to="/protected/settings">Login</Link>
                    </div>
                </div>
                <div className="row">
                    <div className="col-12">
                        <Route path="/public" component={Public}/>
                        <Route path="/login" component={Login}/>
                        <PrivateRoute path="/protected/transactions" component={Protected}/>
                        <PrivateRoute path="/protected/settings" component={Protected}/>
                        <PrivateRoute path="/protected/profile" component={Protected}/>
                    </div>
                </div>
            </div>
        </Router>
    );
}

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

function Public() {
    return <App/>;
}

function Protected() {
    return <div>
        <ul className="nav justify-content-end">
            <li className="nav-item nav-link"><Link to="/protected/transactions">Transactions</Link></li>
            <li className="nav-item nav-link"><Link to="/protected/settings">Settings</Link></li>
            <li className="nav-item nav-link"><Link to="/protected/profile">Profile</Link></li>
        </ul>
        <Route path="/protected/transactions" component={Transactions}/>
        <Route path="/protected/settings" component={() => <Settings userId={window.userId}/>}/>
        <Route path="/protected/profile" component={Profile}/>
    </div>
}

class Login extends Component {

    state = {
        redirectToReferrer: false
    };

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
    };

    getUserByEmail() {
        axios.get("http://localhost:2030/api/users/email/" + this.state.email).then(res => {
            const user = res.data;
            window.userId = user.id;
            //   this.setState({user});
        });
    }

    login = () => {
        fakeAuth.authenticate(() => {
            this.setState({redirectToReferrer: true});
        });
    };

    handleSubmit(event) {
        console.log('submit');
        event.preventDefault();
        this.getUserByEmail();
        this.login();
    }

    render() {
        let {from} = this.props.location.state || {from: {pathname: "/"}};
        let {redirectToReferrer} = this.state;

        if (redirectToReferrer) return <Redirect to={from}/>;

        return (
            <div className="frame-small">
                <div className="login">
                    <p>You must log in to view more information</p>

                    <form className="needs-validation" onSubmit={this.handleSubmit}>
                        <div className="form-group">
                            <label htmlFor="userInputEmail1">Email</label>
                            <input type="email" className="form-control" id="userInputEmail1"
                                   aria-describedby="emailHelp" placeholder="Enter email"
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

export default Start;