import axios from 'axios';

export const getRooms = () => axios.get("http://localhost:8080/api/v1/chat/");