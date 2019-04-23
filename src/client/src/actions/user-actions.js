import {AXIOS_USER} from '../constants';

export function axiosUserAction() {
    return {
        type: AXIOS_USER,
        user: {
            id: 99,
            name: "",
            email: ""
        }
    }
}

export function axiosUserActionAsync() {
    return dispatch => {
        setTimeout(() => {
            dispatch(axiosUserAction());
        }, 10000);
    };
}