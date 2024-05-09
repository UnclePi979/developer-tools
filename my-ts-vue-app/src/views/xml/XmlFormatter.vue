<template>
  <div class="xml-formatter">
    <h2>XML Formatter</h2>
    <a-textarea
      v-model:value="xmlInput"
      placeholder="Enter XML here..."
      rows="10"
      autocapitalize="on"
    ></a-textarea>
    <a-button type="primary" @click="formatXmlHandler">Format XML</a-button>
    <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
    <a-textarea
      v-model:value="formattedXml"
      readonly
      placeholder="Formatted XML will appear here..."
      rows="20"
      autocapitalize="on"
    ></a-textarea>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import { formatXml } from "../../services/api.ts";

const xmlInput = ref<string>("");
const formattedXml = ref<string>("");
const errorMessage = ref<string>("");

async function formatXmlHandler() {
  if (xmlInput.value.trim() === "") {
    errorMessage.value = "Please provide XML to format.";
    return;
  }

  try {
    const formattedData = await formatXml(xmlInput.value);
    if (formattedData) {
      formattedXml.value = formattedData;
      errorMessage.value = "";
    }
  } catch (error) {
    console.error(error);
    errorMessage.value = "An error occurred while formatting XML.";
    formattedXml.value = "";
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
  font-family: "Courier New", monospace;
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
