import React from 'react';
import ReactDOM from 'react-dom';

import {Provider} from 'react-redux';
import {createStore} from 'redux';
import userReducer from './store/reducers/user-reducer.js';

import Router from './router/router.js';
import './styles/style.css';

const initialState = {
    user: {
        id: null,
        name: null,
        email: null
    }
};

const store = createStore(userReducer, initialState,
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

ReactDOM.render(
    <Provider store={store}>
        <Router/>
    </Provider>,
    document.getElementById('app'));