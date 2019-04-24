import {AXIOS_USER} from '../constants';

const initialState = {
    user: {
        id: null,
        name: null,
        email: null
    }
};

function userReducer(state = initialState, action) {
    switch (action.type) {
        case AXIOS_USER:
            return Object.assign({}, state, {user: action.user});
        default:
            return state;
    }
}

export default userReducer;