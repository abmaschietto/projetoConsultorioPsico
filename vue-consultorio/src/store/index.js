import Vue from 'vue'
import Vuex from 'vuex'
import http from '@/services/http'

Vue.use(Vuex)

const state = {
    token:  localStorage.getItem('token') || '', //se o localStorage não estiver aqui, toda vez que a página for recarregada se perde o token
    apelido: ''
}

const mutations = {
    LOGAR_USER(state, {apelido, token}){ // segundo parâmetro recebe object destruction
        state.token = token
        state.apelido = apelido

    },
    DESLOGAR_USER(state){
        state.token = '',
        localStorage.removeItem('token')
    }
}

const actions = {
    logar({commit}, usuario){ //commit deve ser passado entre chaves
        return new Promise((resolve, reject)=>{
            http.post('auth/login', usuario)
            .then( res =>{
                localStorage.setItem('token', res.data.token)
                commit('LOGAR_USER', {apelido: res.data.apelido, token: res.data.token}) // tem que ser passado em chaves (object destruction) se não nunca é pego de imediato
                resolve(res.data)
        }).catch((err) =>{
            console.log(err)
            reject(err)
        })

        
        })
    }
}


export default new Vuex.Store({
    state,
    mutations,
    actions
})