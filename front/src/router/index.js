import Vue from 'vue'
import Router from 'vue-router'
import Home from '../pages/Home.vue'
import About from '../pages/About.vue'
import Yolo from '../pages/Yolo.vue'
import Playground from '../pages/Playground.vue'
import NotFound from '../pages/NotFound.vue'

Vue.use(Router)

export default new Router({
    mode: "history",

    routes: [
        {
            path: '/',
            component: Home,
            name: 'home'
        },
        {
            path: '/about',
            component: About,
            name: 'about'
        },
        {
            path: '/yolo',
            component: Yolo,
            name: 'yolo'
        },
        {
            path: '/playground',
            component: Playground,
            name: 'playground'
        },
        {
            path: '*',
            component: NotFound,
            name: 'NotFound'
        }
    ]

})
