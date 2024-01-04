<script setup lang="ts">
import SiderLogo from './components/SiderLogo.vue'
import SiderMenu from './components/SiderMenu.vue'
</script>

<template>
  <el-container class="h-screen">
    <el-aside width="208px" class="bg-blue-200">
      <el-scrollbar>
        <sider-logo />
        <sider-menu />
      </el-scrollbar>
    </el-aside>
    <el-container>
      <el-header class="bg-red-200" height="56px">Header</el-header>
      <el-main class="main-container bg-yellow-200">
        <el-scrollbar>
          <div class="p-5">
            <router-view />
          </div>
        </el-scrollbar>
      </el-main>
      <el-footer class="flex-center" height="28px">
        <span class="select-none text-sm text-gray-500">© 最终解释权归zbx所有</span>
      </el-footer>
    </el-container>
  </el-container>
</template>
