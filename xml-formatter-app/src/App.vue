<template>
  <div id="app">
    <NavBar/> <!-- NavBar组件 -->
    <main>
      <router-view/>
    </main>
  </div>
</template>

<script lang="ts">
import NavBar from "./components/NavBar/NavBar.vue";

export default {
  name: 'App',
  components: {
    NavBar,
  }
}
</script>

<style>
#app {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

main {
  flex-grow: 1;
  padding: 20px;
}

nav {
  width: 100%; /* 确保导航栏横向铺满 */
  box-shadow: 0 2px 5px rgba(0,0,0,0.1); /* 添加一些轻微的阴影效果增加层次感 */
}

/* 移除了之前的样式以便于添加新的 */
</style>