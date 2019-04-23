import React from 'react';
import ReactDOM from 'react-dom';

import {Provider} from 'react-redux';
import {createStore} from 'redux';
import Reducer from './reducers/user-reducer.js';

import Router from './router/router.js';
import './styles/style.css';

const store = createStore(Reducer, {userId: 4},
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

ReactDOM.render(
    <Provider store={store}>
        <Router/>
    </Provider>,
    document.getElementById('app'));