interface ImportMetaEnv {
  /** 启动端口 */
  VITE_PORT: number
  /** 应用标题名称 */
  VITE_APP_TITLE: string
  // more env variables...
}

interface ImportMeta {
  readonly env: ImportMetaEnv
}
