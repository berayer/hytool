import type { RouteRecordRaw } from 'vue-router'
import HomeLayout from '@/layout/HomeLayout.vue'

/**
 * 静态路由菜单
 */
export const constantRoutes: RouteRecordRaw[] = [
  {
    path: '/',
    redirect: '/home'
  },
  {
    path: '/homeLayout',
    name: 'HomeLayout',
    redirect: '/home',
    component: HomeLayout,
    children: [
      {
        path: '/home',
        component: () => import('@/views/home/index.vue')
      }
    ]
  },
  {
    path: '/login',
    name: 'Login',
    component: () => import('@/views/_/Login.vue')
  },
  {
    path: '/404',
    name: 'PageNotFound',
    component: () => import('@/views/_/404.vue')
  },
  {
    path: '/403',
    name: 'Forbidden',
    component: () => import('@/views/_/403.vue')
  },
  {
    path: '/500',
    name: 'Error',
    component: () => import('@/views/_/500.vue')
  },
  {
    path: '/:path(.*)',
    redirect: '/404'
  }
]
