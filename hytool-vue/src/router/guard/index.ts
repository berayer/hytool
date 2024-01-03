import type { Router } from 'vue-router'
import 'nprogress/nprogress.css'
import NProgress from 'nprogress'
import { loading, removeLoading } from '@/utils/LoadUtil'

/**
 * 路由守卫函数
 * @param router - 路由实例
 */
export function createRouterGuard(router: Router) {
  router.beforeEach(async (_to, _from, next) => {
    if (!window.loading) {
      // 加载启动动画
      loading()
    } else {
      // 开始 loadingBar
      NProgress.start()
    }

    next()
  })

  // 路由结束后操作
  router.afterEach(() => {
    if (!window.loading) {
      // 移除启动动画
      window.loading = true
      removeLoading()
    } else {
      // 结束 loadingBar
      NProgress.done()
    }
  })
}
