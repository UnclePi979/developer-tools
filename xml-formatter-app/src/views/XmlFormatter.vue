<template>
  <div class="xml-formatter">
    <h2>XML Formatter</h2>
    <textarea v-model="xmlInput" placeholder="Enter XML here..." rows="10"></textarea>
    <button @click="formatXml" class="format-button">Format XML</button>
    <div v-if="errorMessage" class="error-message">{{ errorMessage }}</div>
    <textarea v-model="formattedXml" readonly placeholder="Formatted XML will appear here..." rows="20"></textarea>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'XmlFormatter',
  data() {
    return {
      xmlInput: '',
      formattedXml: '',
      errorMessage: ''
    };
  },
  methods: {
    async formatXml() {
      if (this.xmlInput.trim() === '') {
        this.errorMessage = 'Please provide XML to format.';
        return;
      }
      try {
        const response = await axios.post('http://localhost:8081/api/xml/format', this.xmlInput, {
          headers: {
            'Content-Type': 'text/plain'
          }
        });
        // 假设API返回的是纯文本格式化的XML
        this.formattedXml = response.data;
        this.errorMessage = '';
      } catch (error) {
        console.error(error);
        this.errorMessage = error.response && error.response.data ? error.response.data : 'An error occurred while formatting XML.';
        this.formattedXml = '';
      }
    }
  }
};
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