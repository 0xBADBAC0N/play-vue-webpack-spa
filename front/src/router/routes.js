import Home from '../pages/Home.vue'
import About from '../pages/About.vue'
import Yolo from '../pages/Yolo.vue'
import Playground from '../pages/Playground.vue'
import NotFound from '../pages/NotFound.vue'

export default [
        {
            path: '/',
            component: Home,
            name: 'home',
            visible: true
        },
        {
            path: '/about',
            component: About,
            name: 'about',
            visible: true
        },
        {
            path: '/yolo',
            component: Yolo,
            name: 'yolo',
            visible: true
        },
        {
            path: '/playground',
            component: Playground,
            name: 'playground',
            visible: true
        },
        {
            path: '*',
            component: NotFound,
            name: 'NotFound',
            visible: false
        }
    ]
