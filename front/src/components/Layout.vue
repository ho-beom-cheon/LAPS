<template>
  <Header />
  <main class="main-content">
    <router-view /> </main>
  <Footer />
</template>

<script setup>
import Header from './Header.vue';
import Footer from './Footer.vue';
</script>

<style scoped>
.main-content {
  padding: 2rem;
  min-height: calc(100vh - 100px); /* 푸터 높이를 고려한 최소 높이 */
}
</style>