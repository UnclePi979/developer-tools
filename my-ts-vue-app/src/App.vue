<script setup lang="ts">
import {CSSProperties, onMounted} from 'vue';
import AntBar from "./components/NavBar/AntBar.vue";


onMounted(() => {
  console.log(444)
  document.getElementsByTagName("body")[0].style.margin = "0px"
})

const headerStyle: CSSProperties = {
  textAlign: 'center',
  color: '#fff',
  height: 64,
  paddingInline: 50,
  lineHeight: '64px',
  backgroundColor: '#7dbcea',
};

const contentStyle: CSSProperties = {
  textAlign: 'center',
  minHeight: 120,
  color: '#fff',
};

const siderStyle: CSSProperties = {
  textAlign: 'center',
  lineHeight: '120px',
  color: '#fff',
  backgroundColor: '#3ba0e9',
};

const footerStyle: CSSProperties = {
  textAlign: 'center',
  color: '#fff',
  backgroundColor: '#7dbcea',
};
</script>

<template>
  <div style="height: 100vh">
    <a-space direction="vertical" :style="{ width: '100%' }" :size="[0, 48]">
      <a-layout>
        <a-layout-header :style="headerStyle">Header</a-layout-header>
        <a-layout>
          <a-layout-sider :style="siderStyle">
            <AntBar/>
          </a-layout-sider>
          <a-layout-content :style="contentStyle">
            <index/>

          </a-layout-content>
        </a-layout>
        <a-layout-footer :style="footerStyle">Footer</a-layout-footer>
      </a-layout>
    </a-space>
  </div>
</template>

<style scoped>
</style>
