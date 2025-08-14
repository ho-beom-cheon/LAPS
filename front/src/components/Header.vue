<template>
  <header class="main-header">
    <div class="header-content">
      <router-link to="/" class="logo">P2P Project</router-link>
      <nav class="main-nav">
        <router-link to="/loans">대출 상품</router-link>
        <router-link to="/mypage">마이페이지</router-link>
        <router-link to="/login">로그인</router-link>
      </nav>
    </div>
  </header>
</template>

<script setup>
// 필요한 스크립트 로직
</script>

<style scoped>
.main-header {
  background-color: #333;
  color: white;
  padding: 1rem;
  height: 80px;
}
.header-content {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  margin: 0 auto;
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
</style>