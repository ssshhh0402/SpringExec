import axios from 'axios';

export const localLogin = ({email, password}) => axios.post('http://localhost:8080/api/v1/user/login', {email, password});