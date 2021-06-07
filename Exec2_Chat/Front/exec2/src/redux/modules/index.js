import { combineReducers } from 'redux';
import base from './base';
import auth from './auth';
import main from './main';
import { penderReducer } from 'redux-pender';


export default combineReducers({
    base,
    auth,
    main,
    pender: penderReducer
});