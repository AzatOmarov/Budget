import React from 'react';
import ReactDOM from 'react-dom';
import router from './router/router.js';
import MyRouter from './router/MyRouter';

import './styles/style.css';

ReactDOM.render(router, document.getElementById('app'));
//ReactDOM.render(<MyRouter/>, document.getElementById('app'));