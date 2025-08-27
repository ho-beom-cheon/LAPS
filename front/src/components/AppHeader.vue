<template>
  <header class="app-header">
    <div class="header-container">
      <router-link to="/" class="logo">LAPS</router-link>

      <!-- 데스크톱용 내비게이션 -->
      <nav class="desktop-nav">
        <router-link to="/loan-products">대출 상품</router-link>
        <router-link to="/apply">대출 신청</router-link>
        <router-link to="/my-page">마이페이지</router-link>
      </nav>

      <!-- 모바일용 햄버거 메뉴 버튼 -->
      <button class="hamburger-menu" @click="toggleMobileMenu" aria-label="메뉴 열기">
        <span class="bar"></span>
        <span class="bar"></span>
        <span class="bar"></span>
      </button>
    </div>

    <!-- 모바일용 내비게이션 (토글) -->
    <nav v-if="isMobileMenuOpen" class="mobile-nav">
      <router-link to="/loan-products" @click="closeMobileMenu">대출 상품</router-link>
      <router-link to="/apply" @click="closeMobileMenu">대출 신청</router-link>
      <router-link to="/my-page" @click="closeMobileMenu">마이페이지</router-link>
    </nav>
  </header>
</template>

<script setup lang="ts">
import { ref } from 'vue';

const isMobileMenuOpen = ref(false);

const toggleMobileMenu = () => {
  isMobileMenuOpen.value = !isMobileMenuOpen.value;
};

const closeMobileMenu = () => {
  isMobileMenuOpen.value = false;
};
</script>

<style scoped>
.app-header {
  background-color: #2c3e50;
  color: white;
  padding: 0 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  position: relative;
  z-index: 1000;
}

.header-container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 60px;
  max-width: 1200px;
  margin: 0 auto;
}

.logo {
  font-size: 1.5rem;
  font-weight: bold;
  color: white;
  text-decoration: none;
}

.desktop-nav {
  display: none; /* 모바일에서는 숨김 */
}

.desktop-nav a {
  color: white;
  text-decoration: none;
  margin-left: 24px;
  font-size: 1rem;
}

.hamburger-menu {
  display: flex; /* 모바일에서만 보임 */
  flex-direction: column;
  justify-content: space-around;
  width: 28px;
  height: 24px;
  background: transparent;
  border: none;
  cursor: pointer;
  padding: 0;
}

.hamburger-menu .bar {
  width: 100%;
  height: 3px;
  background-color: white;
  border-radius: 2px;
}

.mobile-nav {
  display: flex;
  flex-direction: column;
  background-color: #34495e;
  position: absolute;
  top: 60px;
  left: 0;
  right: 0;
  padding-bottom: 10px;
}

.mobile-nav a {
  color: white;
  text-decoration: none;
  padding: 15px 20px;
  text-align: center;
}

.mobile-nav a:hover {
  background-color: #4a627b;
}

/* 화면이 768px 이상일 때 (태블릿, 데스크톱) */
@media (min-width: 768px) {
  .desktop-nav {
    display: flex; /* 데스크톱 메뉴 보이기 */
  }
  .hamburger-menu {
    display: none; /* 햄버거 버튼 숨기기 */
  }
  .mobile-nav {
    display: none !important; /* 모바일 메뉴 항상 숨기기 */
  }
}
</style>