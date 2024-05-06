import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import XmlFormatter from "../views/XmlFormatter.vue";

const routes: Array<RouteRecordRaw> = [
    {
        path: '/xml-formatter',
        name: 'XmlFormatter',
        component: XmlFormatter
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;