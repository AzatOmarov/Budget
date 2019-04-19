import {AXIOS_USER} from '../constants';

const initialState = {
    user: {}
};

function userReducer(state = initialState, action) {
    switch (action.type) {
        case AXIOS_USER:
            return Object.assign({}, state, {user: action.user});
        default:
            return state
    }
}

export default userReducer;