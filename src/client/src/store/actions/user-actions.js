import {AXIOS_USER} from '../constants';

export function axiosUserAction(user) {
    return {
        type: AXIOS_USER,
        user: {
            id: user.id,
            name: user.name,
            email: user.email
        }
    }
}
