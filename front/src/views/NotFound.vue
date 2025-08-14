<template>
  <div class="not-found-container">
    <div class="content">
      <h1 class="status-code">404</h1>
      <h2 class="message">페이지를 찾을 수 없습니다.</h2>
      <p class="description">
        요청하신 페이지가 존재하지 않거나, 주소가 변경되었을 수 있습니다.
      </p>
      <router-link to="/" class="home-link">홈으로 돌아가기</router-link>
    </div>
  </div>
</template>

<script setup>
// 이 페이지에는 별도의 스크립트 로직이 필요하지 않습니다.
</script>

<style scoped>
.not-found-container {
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  min-height: 60vh; /* 페이지의 콘텐츠 영역을 충분히 채우도록 설정 */
  color: #333;
}

.content {
  max-width: 500px;
}

.status-code {
  font-size: 8rem;
  font-weight: bold;
  color: #007bff;
  margin: 0;
  line-height: 1;
}

.message {
  font-size: 2.2rem;
  margin-top: 1rem;
  margin-bottom: 1rem;
}

.description {
  font-size: 1.1rem;
  color: #666;
  margin-bottom: 2.5rem;
}

.home-link {
  display: inline-block;
  padding: 0.8rem 2rem;
  border-radius: 5px;
  font-size: 1.1rem;
  text-decoration: none;
  background-color: #007bff;
  color: white;
  transition: background-color 0.3s ease;
}

.home-link:hover {
  background-color: #0056b3;
}
</style>