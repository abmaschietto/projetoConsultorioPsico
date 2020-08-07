import Vue from 'vue'
import App from './App.vue'
import Navegacao from './components/shared/navegacao'
import Footer from './components/shared/footer'
import http from '@/services/http'
import store from '@/store/index'
import router from './routes'


Vue.config.productionTip = false
Vue.component('navegador', Navegacao);
Vue.component('rodape', Footer)

Vue.prototype.$http = http


new Vue({
  render: h => h(App),
  router,
  store
}).$mount('#app')
