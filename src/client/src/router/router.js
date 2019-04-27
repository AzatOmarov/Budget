import React, {Component} from 'react';
import {BrowserRouter as Router, Link, Redirect, Route, Switch, withRouter} from 'react-router-dom';
import {connect} from 'react-redux';

import App from '../components/containers/app/App.js';
import Transactions from '../components/containers/transactions/Transactions.js';
import Wallet from '../components/containers/wallet/Wallet.js';
import Categories from '../components/containers/categories/Categories.js';
import Profile from '../components/containers/profile/Profile.js';

import axios from 'axios';
import {axiosUserAction} from '../store/actions/user-actions';

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
        let {from} = this.props.location.state || {from: {pathname: "/wallet"}};
        let {redirectToReferrer} = this.state;

        if (redirectToReferrer) return <Redirect to={from}/>;

        return (
            <div className="frame-small">
                <div className="login">
                    <p>You must log in to view more information</p>
                    <form className="needs-validation" onSubmit={this.handleSubmit}>
                        <div className="form-group">
                            <label htmlFor="userInputEmail">Email</label>
                            <input type="email"
                                   className="form-control"
                                   id="userInputEmail"
                                   value={this.state.email}
                                   onChange={this.handleChange}
                                   aria-describedby="emailHelp"
                                   placeholder="Enter email"
                                   required/>
                            <small id="emailHelp" className="form-text text-muted">
                                We'll never share your email with anyone else.
                            </small>
                        </div>
                        <div className="form-group">
                            <label htmlFor="userInputPassword">Password</label>
                            <input type="password"
                                   className="form-control"
                                   id="userInputPassword"
                                   placeholder="Password"
                                   required/>
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

function Start() {
    return (
        <Router>
            <div className="container">
                <div className="row">
                    <div className="col-6"/>
                    <div className="col-6 auth">
                        <AuthLink/>
                    </div>
                </div>
                <div className="row">
                    <div className="col-12">
                        <Switch>
                            <Route exact path="/" component={App}/>
                            <Route path="/login" component={WrappedLogin}/>
                            <PrivateRoute path="/transactions" component={Protected}/>
                            <PrivateRoute path="/wallet" component={Protected}/>
                            <PrivateRoute path="/categories" component={Protected}/>
                            <PrivateRoute path="/profile" component={Protected}/>
                            <Redirect to="/"/>
                        </Switch>
                    </div>
                </div>
            </div>
        </Router>
    );
}

function Protected() {
    return <div>
        <ul className="nav justify-content-end">
            <li className="nav-item nav-link"><Link to="/transactions">Transactions</Link></li>
            <li className="nav-item nav-link"><Link to="/wallet">Wallet</Link></li>
            <li className="nav-item nav-link"><Link to="/categories">Categories</Link></li>
            <li className="nav-item nav-link"><Link to="/profile">Profile</Link></li>
        </ul>
        <Route path="/transactions" component={Transactions}/>
        <Route path="/wallet" component={Wallet}/>
        <Route path="/categories" component={Categories}/>
        <Route path="/profile" component={Profile}/>
    </div>
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

const AuthLink = withRouter(
    ({history}) =>
        fakeAuth.isAuthenticated ? (
            <a href="/"
               onClick={() => {
                   fakeAuth.signout(() => history.push("/"));
               }}
            >
                Sign out
            </a>
        ) : (
            <Link to="/login">Login</Link>
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

const mapStateToProps = state => ({user: state.user});

export default connect(mapStateToProps)(Start);