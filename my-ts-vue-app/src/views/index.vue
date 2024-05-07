<template>
  <div class="p-4">

    <div class="md:flex enter-y">
      <router-view/>
    </div>
  </div>
</template>
<script lang="ts" setup>
import {ref} from 'vue';

const loading = ref(true);

setTimeout(() => {
  loading.value = false;
}, 1500);
</script>
