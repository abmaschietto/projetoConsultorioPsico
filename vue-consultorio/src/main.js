import Vue from 'vue'
import App from './App.vue'
import Navegacao from './components/shared/navegacao'
import Footer from './components/shared/footer'
import http from '@/services/http'
import store from '@/store/index'
import router from './routes'
import MenuMobile from '@/components/shared/MenuMobile'
import vuetify from './plugins/vuetify';
import 'roboto-fontface/css/roboto/roboto-fontface.css'
import '@mdi/font/css/materialdesignicons.css'


Vue.config.productionTip = false
Vue.component('navegador', Navegacao);
Vue.component('menuMobile', MenuMobile)
Vue.component('rodape', Footer)


Vue.prototype.$http = http


new Vue({
  render: h => h(App),
  router,
  vuetify,
  store
}).$mount('#app')
