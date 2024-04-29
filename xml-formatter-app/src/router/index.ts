import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import XmlFormatter from '../views/XmlFormatter.vue'
import XmlCompress from '../views/XmlCompress.vue'

const routes: Array<RouteRecordRaw> = [
    {
        path: '/xml-formatter',
        name: 'XmlFormatter',
        component: XmlFormatter
    },
    {
        path: '/xml-compress',
        name: 'XmlPretify',
        component: XmlCompress
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;