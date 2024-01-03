import { createApp } from 'vue'
import App from './App.vue'
import { setupRouter } from '@/router'

async function setupApp() {
  const app = createApp(App)
  // 按照路由
  await setupRouter(app)
  // 挂载实例
  app.mount('#app')
}

// 安装app
setupApp()
