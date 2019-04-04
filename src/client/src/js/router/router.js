import {Router, Link, Route} from 'react-router-dom'
import React from 'react';
import {createBrowserHistory} from 'history';

import Transactions from '../components/container/Transactions.js';
import Settings from '../components/container/Settings.js';
import Profile from '../components/container/Profile.js';
import App from '../App.js';

const hist = createBrowserHistory();

const router = (
    <Router history={hist}>
        <div>
            <ul className="nav-fill navbar navbar-light bg-light">
                <li className="nav-item nav-link"><Link to="/">Home</Link></li>
                <li className="nav-item nav-link"><Link to="/transactions">Transactions</Link></li>
                <li className="nav-item nav-link"><Link to="/settings">Settings</Link></li>
                <li className="nav-item nav-link"><Link to="/profile">Profile</Link></li>
            </ul>
            <Route path="/" exact component={App}/>
            <Route path="/transactions" component={Transactions}/>
            <Route path="/settings" component={Settings}/>
            <Route path="/profile" component={Profile}/>
        </div>
    </Router>
);

export default router;