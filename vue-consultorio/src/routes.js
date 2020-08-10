import Vue from 'vue'
import VueRouter from 'vue-router'
import Pacientes from './components/Pacientes';
import Doutores from './components/Doutores';
import Inicial from './components/Inicial';
import Pepe from './components/Pepe'
import Login from './components/Login'
import store from '@/store/index'

Vue.use(VueRouter)

export const routes = [
    {path:'*', component: Inicial, meta:{protegido: false}},
    {path:'/pacientes', component: Pacientes, name:'pacientes', meta:{protegido: true}},
    {path:'/doutores', component: Doutores, name:'doutores', meta:{protegido: true}},
    {path:'/login', component: Login, name:'login', meta:{protegido: false}},
    {path:'/pepe', component: Pepe, name:'pepe', meta:{protegido: false}}
]
const router = new VueRouter({
    routes,
    mode: 'history'
})


router.beforeEach ((routerTo, routerFrom, next)=>{
    if(routerTo.meta.protegido && !store.state.token){
      return next({path: '/login'})
    }else{
      next()
    }
  })

  export default router