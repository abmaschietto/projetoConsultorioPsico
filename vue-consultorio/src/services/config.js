import axios from 'axios';

export const http = axios.create({
    baseURL:'https://consultorio-api-java.herokuapp.com/api/'
})