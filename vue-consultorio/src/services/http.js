import axios from 'axios'
import store from '@/store/index'

const http = axios.create({
    baseURL: 'https://consultorio-api-java.herokuapp.com/',
    headers:{
        'Accept': 'application/json',
        'Content': 'application/json'
    }
})

http.interceptors.request.use((configure)=>{
    const token = store.state.token
    if(token){
        configure.headers.Authorization = `Bearer ${token}`

    }
    return configure
}, (err)=>{
    return Promise.reject(err)
})

export default http