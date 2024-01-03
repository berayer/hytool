import { defineConfig, loadEnv } from 'vite'
import vue from '@vitejs/plugin-vue'
import { fileURLToPath, URL } from 'node:url'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import { ElementPlusResolver } from 'unplugin-vue-components/resolvers'

/**
 * vite 配置
 */
export default defineConfig(({ mode }) => {
  // 加载当前环境变量
  const viteEnv = loadEnv(mode, process.cwd()) as unknown as ImportMetaEnv

  return {
    plugins: [
      vue(),
      // API自动导入
      AutoImport({
        imports: ['vue'],
        dts: 'src/types/auto-import.d.ts',
        resolvers: [ElementPlusResolver()]
      }),
      // 组件自动导入
      Components({
        dts: 'src/types/components.d.ts',
        resolvers: [ElementPlusResolver({ importStyle: 'sass' })]
      })
    ],
    resolve: {
      alias: {
        '@': fileURLToPath(new URL('./src', import.meta.url)),
        '~': fileURLToPath(new URL('./', import.meta.url))
      }
    },
    server: {
      host: '0.0.0.0',
      port: viteEnv.VITE_PORT || 8888,
      // 代理服务器配置
      proxy: {
        '/v2': {
          target: 'http://localhost:9002',
          changeOrigin: true,
          rewrite: (path) => path.replace(/^\/v2/, '')
        }
      }
    },
    css: {
      preprocessorOptions: {
        scss: {
          additionalData: '@use "@/styles/element.scss" as *;'
        }
      }
    }
  }
})
