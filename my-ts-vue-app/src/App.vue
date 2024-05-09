<script setup lang="ts">
import { CSSProperties } from "vue";
import AntBar from "./components/NavBar/AntBar.vue";
import index from "./views/index.vue";

const headerStyle: CSSProperties = {
  textAlign: "center",
  color: "#fff",
  height: 64,
  paddingInline: 50,
  lineHeight: "64px",
  backgroundColor: "#7dbcea",
  fontSize: "30px",
};

const contentStyle: CSSProperties = {
  minHeight: 120,
  color: "black",
};

const siderStyle: CSSProperties = {
  lineHeight: "120px",
  color: "#fff",
  backgroundColor: "#3ba0e9",
  overflow: "hidden",
};

const footerStyle: CSSProperties = {
  textAlign: "center",
  color: "#fff",
  backgroundColor: "#7dbcea",
};
</script>

<template>
  <div style="height: 100vh">
    <a-space direction="vertical" :style="{ width: '100%' }" :size="[0, 48]">
      <a-layout>
        <a-layout-header :style="headerStyle">Developer Tools</a-layout-header>
        <a-layout>
          <a-layout-sider :style="siderStyle" width="250px">
            <div class="ant-bar">
              <AntBar />
            </div>
          </a-layout-sider>
          <a-layout-content :style="contentStyle">
            <index />
          </a-layout-content>
        </a-layout>
        <a-layout-footer :style="footerStyle"
          >Ant Design ©2024 Created by Ant UED</a-layout-footer
        >
      </a-layout>
    </a-space>
  </div>
</template>

<style scoped>
body {
  margin: 0;
}

.ant-bar {
  display: flex;
  flex-direction: column;
  height: 100%;
  width: 100%;
  min-height: 100%;
  background-color: white;
}
</style>
