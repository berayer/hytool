/* eslint-disable @typescript-eslint/no-explicit-any */
/**
 * 全局变量配置
 */
declare module 'element-plus/dist/locale/zh-cn.mjs'

type AnyObj = {
  [key: string | number | symbol]: any
}

interface Window {
  loading?: boolean
}
