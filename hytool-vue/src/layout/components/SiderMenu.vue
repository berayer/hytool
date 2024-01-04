<template>
  <el-menu default-active="1">
    <el-menu-item index="1">
      <span>首页</span>
    </el-menu-item>

    <el-menu-item index="2">
      <span>应用</span>
    </el-menu-item>

    <el-sub-menu index="3">
      <template #title>
        <span>系统设置</span>
      </template>

      <el-menu-item index="3-1">
        <span>用户管理</span>
      </el-menu-item>

      <el-menu-item index="3-2">
        <span>角色管理</span>
      </el-menu-item>

      <el-menu-item index="3-3">
        <span>菜单管理</span>
      </el-menu-item>
    </el-sub-menu>
  </el-menu>
</template>
