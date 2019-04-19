import React from 'react';
import ReactDOM from 'react-dom';
import Router from './router/router.js';

import {Provider} from 'react-redux';
import {createStore} from 'redux';
import {applyMiddleware} from 'redux';
import logger from 'redux-logger';
import thunk from 'redux-thunk';
import reducer from './reducers/user-reducer.js';

import './styles/style.css';

const store = createStore(reducer, {userId: 4},
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

ReactDOM.render(
    <Provider store={store}>
        <Router/>
    </Provider>,
    document.getElementById('app'));