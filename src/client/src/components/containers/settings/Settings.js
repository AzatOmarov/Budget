import React from 'react';
import {Link, Route} from 'react-router-dom';

const Settings = ({match}) => {
    return (
        <div>
            <p>Settings</p>
            <div>
                <ul>
                    <li><Link to={`${match.url}/categories`}>Categories</Link></li>
                    <li><Link to={`${match.url}/wallet`}>Wallet</Link></li>
                </ul>

                <Route exact path={`${match.path}/:settings`}
                       render={({match}) => (<div> This is {match.params.settings} </div>)}/>
            </div>
        </div>
    );
};

export default Settings;