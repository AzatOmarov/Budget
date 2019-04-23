import React, {Component} from 'react';
import {BrowserRouter as Router, Link, Route} from 'react-router-dom';

import Title from '../../UIComponents/header/title/Title.js';
import Slogan from '../../UIComponents/header/slogan/Slogan.js';
import Wallet from './wallet/Wallet.js';
import Categories from './categories/Categories.js';

class Settings extends Component {
    render() {
        return (
            <div className="container">
                <div className="row">
                    <div className="col-5">
                        <p/>
                        <Title/>
                    </div>
                    <div className="col-7">
                        <Slogan/>
                    </div>
                </div>
                <div className="frame-big">
                    <div className="row">
                        <div className="col-12">
                            <div className="main-block">
                                <h3>Settings</h3>
                                <p>Do not forget to also configure all the necessary data for comfortable work:</p>
                                <ul>
                                    <li>add your Wallet, set an initial balance and choose a suitable currency,</li>
                                    <li>see the list of proposed spending and income categories.</li>
                                </ul>
                                <Router>
                                    <div>
                                        <ul className="nav sub-nav">
                                            <li className="nav-item nav-link">
                                                <Link to="/settings/wallet">Wallet</Link>
                                            </li>
                                            <li className="nav-item nav-link">
                                                <Link to="/settings/categories">Categories</Link>
                                            </li>
                                        </ul>
                                        <Route path="/settings/wallet" component={Wallet}/>
                                        <Route path="/settings/categories" component={Categories}/>
                                    </div>
                                </Router>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default Settings;