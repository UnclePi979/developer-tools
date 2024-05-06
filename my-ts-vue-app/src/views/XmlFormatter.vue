<template>
  <div class="xml-formatter">
    <h2>XML Formatter</h2>
    <textarea v-model="xmlInput" placeholder="Enter XML here..." rows="10"></textarea>
    <button @click="formatXml" class="format-button">Format XML</button>
    <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
    <textarea v-model="formattedXml" readonly placeholder="Formatted XML will appear here..." rows="20"></textarea>
  </div>
</template>

<script setup lang="ts">
import {ref} from 'vue';
import axios, {AxiosError} from 'axios';

const xmlInput = ref('');
const formattedXml = ref('');
const errorMessage = ref('');

async function formatXml() {
  if (xmlInput.value.trim() === '') {
    errorMessage.value = 'Please provide XML to format.';
    return;
  }
  try {
    const response = await axios.post('http://localhost:8081/api/xml/format', xmlInput.value, {
      headers: {
        'Content-Type': 'text/plain'
      }
    });
    formattedXml.value = response.data;
    errorMessage.value = '';
  } catch (error) {
    const typedError = error as AxiosError;
    console.error(error);
    errorMessage.value = <string>typedError.response?.data || 'An error occurred while formatting XML.';
    formattedXml.value = '';
  }
}
</script>

<style scoped>
.xml-formatter {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.xml-formatter textarea {
  width: 100%;
  margin-bottom: 10px;
  padding: 10px;
  font-family: 'Courier New', monospace;
}

.format-button {
  padding: 10px 20px;
  margin-bottom: 10px;
}

.error-message {
  color: red;
  margin-bottom: 10px;
}
</style>