import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import XmlFormatter from "../views/xml/XmlFormatter.vue";
import XmlCompress from '../views/xml/XmlCompress.vue';
import Markdown from "../views/markdown/Markdown.vue";

const routes: Array<RouteRecordRaw> = [
    {
        path: '/xml-formatter',
        name: 'XmlFormatter',
        component: XmlFormatter
    },
    {
        path: '/xml-compress',
        name: 'XmlCompress',
        component: XmlCompress
    },
    {
        path: '/markdown',
        name: 'Markdown',
        component: Markdown
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router;