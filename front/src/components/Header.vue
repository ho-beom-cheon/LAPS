<template>
  <header class="main-header">
    <div class="header-content">
      <router-link to="/" class="logo">P2P</router-link>
      <template v-if="!isErrorPage">
        <button class="mobile-nav-toggle" @click="toggleMenu" :aria-expanded="isMenuOpen" aria-controls="main-nav">
          <span class="sr-only">메뉴</span>
          <span class="hamburger-icon"></span>
        </button>
        <nav class="main-nav" :class="{ 'is-open': isMenuOpen }" id="main-nav">
          <router-link to="/loans">대출 상품</router-link>
          <router-link to="/about">회사 소개</router-link>
          <router-link to="/mypage">마이페이지</router-link>
          <router-link to="/login">로그인</router-link>
        </nav>
      </template>
    </div>
  </header>
</template>

<script setup>
import { ref, computed } from 'vue';
import { useRoute } from 'vue-router';

const isMenuOpen = ref(false);

const toggleMenu = () => {
  isMenuOpen.value = !isMenuOpen.value;
};

const route = useRoute();
// 'NotFound' 라우트일 경우 true를 반환하여 메뉴를 숨깁니다.
const isErrorPage = computed(() => route.name === 'NotFound');
</script>

<style scoped>
.main-header {
  background-color: #333;
  color: white;
  padding: 0;
  height: 80px;
  width: 100%;
  display: flex;
  align-items: center;
  position: relative; /* 자식 요소의 absolute 포지셔닝 기준 */
}
.header-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  max-width: 1200px;
  width: 100%;
  margin: 0 auto;
  padding: 0 2rem;
  box-sizing: border-box;
}
.logo {
  color: white;
  font-size: 1.5rem;
  font-weight: bold;
  text-decoration: none;
}
.main-nav a {
  color: white;
  text-decoration: none;
  margin-left: 1.5rem;
}

.mobile-nav-toggle {
  display: none;
}

/* 모바일 화면 (768px 이하) */
@media (max-width: 768px) {
  .main-nav {
    display: none;
    position: absolute;
    top: 80px; /* 헤더 높이 */
    left: 0;
    right: 0;
    background-color: #333;
    flex-direction: column;
    padding: 1rem 0;
    box-shadow: 0 4px 6px rgba(0,0,0,0.1);
  }

  .main-nav.is-open {
    display: flex;
  }

  .main-nav a {
    margin: 0;
    padding: 1rem;
    width: 100%;
    text-align: center;
  }

  .main-nav a:hover {
    background-color: #555;
  }

  .mobile-nav-toggle {
    display: block;
    background: transparent;
    border: none;
    cursor: pointer;
    padding: 10px;
    z-index: 1000;
  }

  .sr-only {
    position: absolute;
    width: 1px;
    height: 1px;
    padding: 0;
    margin: -1px;
    overflow: hidden;
    clip: rect(0, 0, 0, 0);
    white-space: nowrap;
    border: 0;
  }

  .hamburger-icon {
    position: relative;
    display: block;
    width: 24px;
    height: 2px;
    background-color: white;
    transition: background-color 0.2s ease-in-out;
  }

  .hamburger-icon::before,
  .hamburger-icon::after {
    content: '';
    position: absolute;
    left: 0;
    width: 100%;
    height: 2px;
    background-color: white;
    transition: transform 0.2s ease-in-out;
  }

  .hamburger-icon::before {
    top: -8px;
  }

  .hamburger-icon::after {
    bottom: -8px;
  }

  .mobile-nav-toggle[aria-expanded="true"] .hamburger-icon {
    background-color: transparent; /* 중간 선 사라짐 */
  }

  .mobile-nav-toggle[aria-expanded="true"] .hamburger-icon::before {
    transform: translateY(8px) rotate(45deg);
  }

  .mobile-nav-toggle[aria-expanded="true"] .hamburger-icon::after {
    transform: translateY(-8px) rotate(-45deg);
  }
}
</style>