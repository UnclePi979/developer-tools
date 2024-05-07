<template>
  <div class="xml-formatter">
    <h2>XML Formatter</h2>
    <textarea v-model="xmlInput" placeholder="Enter XML here..." rows="10"></textarea>
    <button @click="formatXmlHandler" class="format-button">Format XML</button>
    <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
    <textarea v-model="formattedXml" readonly placeholder="Formatted XML will appear here..." rows="20"></textarea>
  </div>
</template>

<script setup lang="ts">
import {ref} from 'vue';
import { formatXml } from '../../services/api.ts';

const xmlInput = ref('');
const formattedXml = ref('');
const errorMessage = ref('');

async function formatXmlHandler() {
  if (xmlInput.value.trim() === '') {
    errorMessage.value = 'Please provide XML to format.';
    return;
  }

  try {
    const formattedData = await formatXml(xmlInput.value);
    if (formattedData) {
      formattedXml.value = formattedData;
      errorMessage.value = '';
    }
  } catch (error) {
    console.error(error);
    errorMessage.value = 'An error occurred while formatting XML.';
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