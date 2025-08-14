<template>
  <div class="layout-container">
    <Header />
    <main class="main-content">
      <router-view />
    </main>
    <Footer />
  </div>
</template>

<script setup>
import Header from './Header.vue';
import Footer from './Footer.vue';
</script>

<style scoped>
.layout-container {
  display: flex;
  flex-direction: column;
  width: 100%;
  min-height: 100vh;
}
.main-content {
  flex-grow: 1;
  width: 100%;
  max-width: 1200px; /* 콘텐츠 최대 너비를 1200px로 제한 */
  margin: 0 auto; /* 좌우 마진을 auto로 주어 중앙 정렬 */
  padding: 2rem;
  box-sizing: border-box; /* padding이 너비에 포함되도록 설정 */
}
</style>