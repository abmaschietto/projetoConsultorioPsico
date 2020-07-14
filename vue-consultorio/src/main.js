import Vue from 'vue'
import App from './App.vue'
import Navegacao from './components/shared/navegacao'
import VueRouter from 'vue-router'
import { routes } from './routes'
import Footer from './components/shared/footer'

Vue.use(VueRouter);
Vue.config.productionTip = false
Vue.component('navegador', Navegacao);
Vue.component('rodape', Footer)

const router = new VueRouter({
  routes,
  mode: 'history'
})

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
