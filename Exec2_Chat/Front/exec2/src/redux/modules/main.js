import { createAction, handleActions } from 'redux-actions';
import { pender } from 'redux-pender';
import * as MainAPI from '../../lib/api/main';
import { Map } from 'immutable';

const GET_ROOMS = 'main/GET_ROOMS'; // 채팅방 정보 호출
const INNITIALIZE_ROOMS = 'main/INNITIALIZE_ROOMS';
const SET_ERROR = 'main/SET_ERROR';

export const GETROOMS = createAction(GET_ROOMS,MainAPI.getRooms); //  { form, name, value }
export const INNITIALIZEROOMS = createAction(INNITIALIZE_ROOMS);
export const SETERROR = createAction(SET_ERROR);

const initialState = Map({
    rooms: Map({
        title : '',
        url : '',
        error: null
    }),

    result: Map({})
});

export default handleActions({
    [GET_ROOMS]: (state, action) => {
        const { rooms, name, value } = action.payload.data;
        console.log(rooms);  
        return state.setIn([rooms, 'rooms', name], value);
    },
    [INNITIALIZE_ROOMS]: (state, action) => {
        const initialForm = initialState.get(action.payload);
        return state.set(action.payload, initialForm);
    },
    [SET_ERROR]: (state, action) => {
        const { form, message } = action.payload;
        return state.setIn([form, 'error'], message);
    },
    ...pender({
        type:GETROOMS,
        onSuccess: (state, action) => state.set('result', Map(action.payload.data))
    })
}, initialState);