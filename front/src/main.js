import Vue from 'vue'
import router from './router'
import Main from './layouts/Main.vue'

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

Vue.use(BootstrapVue);

const app = new Vue({
  el: '#app',
  components:{
    Main
  },
  template: '<Main/>',
  router
});
