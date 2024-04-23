<template>
  <nav class="nav-bar">
    <ul class="nav-list">
      <li class="nav-item" v-for="item in menuItems" :key="item.text">
        <router-link :to="item.path" class="nav-link">{{ item.text }}</router-link>
      </li>
    </ul>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      menuItems: [
        { text: 'Home', path: '/' },
        { text: 'XML Formatter', path: '/xml-formatter' },
        { text: 'XML Compress', path: '/xml-compress' },
        { text: 'Contact', path: '/contact' }
        // 更多 menu item ...
      ]
    };
  }
  // 如果你使用TypeScript，你还需要定义相关的接口或类型
};
</script>

<style scoped>
.nav-bar {
  background-color: #004d99; /* 导航栏背景色 */
  color: white;
}

.nav-list {
  list-style-type: none;
  margin: 0;
  padding: 0;
  display: flex; /* 使用flex布局让导航项水平排列 */
  justify-content: center; /* 将导航项居中对齐 */
}

.nav-item {
  margin: 0 10px; /* 水平间距 */
}

.nav-link {
  color: white;
  text-decoration: none;
  padding: 15px 20px;
  display: block; /* 使链接覆盖整个列表项区域 */
  transition: background-color 0.3s ease; /* 添加过渡动效 */
}

.nav-link:hover,
.router-link-active {
  background-color: #003366; /* 鼠标悬停和当前导航项的背景色 */
}
</style>