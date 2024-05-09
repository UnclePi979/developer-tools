<template>
  <div class="xml-compress">
    <h2>XML Compress</h2>
    <a-textarea
      v-model:value="xmlInput"
      placeholder="Enter XML here..."
      rows="10"
    ></a-textarea>
    <a-button type="primary" @click="compressXmlHandler">Compress XML</a-button>
    <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
    <a-textarea
      v-model:value="compressedXml"
      readonly
      placeholder="Compressed XML will appear here..."
      rows="20"
    ></a-textarea>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import { compressXml } from "../../services/api.ts";

const xmlInput = ref("");
const compressedXml = ref("");
const errorMessage = ref("");

async function compressXmlHandler() {
  if (xmlInput.value.trim() === "") {
    errorMessage.value = "Please provide XML to format.";
    return;
  }

  try {
    const compressedData = await compressXml(xmlInput.value);
    if (compressedData) {
      compressedXml.value = compressedData;
      errorMessage.value = "";
    }
  } catch (error) {
    console.error(error);
    errorMessage.value = "An error occurred while formatting XML.";
    compressedXml.value = "";
  }
}
</script>

<style scoped>
.xml-compress {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.xml-compress textarea {
  width: 100%;
  margin-bottom: 10px;
  padding: 10px;
  font-family: "Courier New", monospace;
}

.error-message {
  color: red;
  margin-bottom: 10px;
}
</style>
