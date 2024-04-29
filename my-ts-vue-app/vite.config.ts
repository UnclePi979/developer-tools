import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
    plugins: [vue()],
    base: './', // 打包路径
    server: {
        port: 3000, // 服务端口
        open: true, // 启动服务时是否自动打开浏览器
        cors: true, // 允许跨域
    }
})
