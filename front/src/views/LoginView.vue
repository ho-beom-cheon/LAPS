<template>
  <div class="login-container">
    <div class="login-card">
      <h1 class="title">로그인</h1>
      <form @submit.prevent="handleLogin">
        <div class="input-group">
          <label for="email">이메일</label>
          <input type="email" id="email" v-model="email" required placeholder="email@example.com" />
        </div>
        <div class="input-group">
          <label for="password">비밀번호</label>
          <input type="password" id="password" v-model="password" required placeholder="비밀번호를 입력하세요" />
        </div>
        <button type="submit" class="login-button">로그인</button>
      </form>
      <div class="links">
        <router-link to="/register">회원가입</router-link>
        <router-link to="/forgot-password">비밀번호 찾기</router-link>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const email = ref('');
const password = ref('');
const router = useRouter();

const handleLogin = () => {
  // TODO: 실제 로그인 로직을 구현해야 합니다.
  console.log('Login attempt with:', email.value, password.value);
  // 로그인 성공 시 홈으로 리디렉션
  // router.push('/');
};
</script>

<style scoped>
.login-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 70vh;
  padding: 2rem 0;
}

.login-card {
  width: 100%;
  max-width: 420px;
  padding: 3rem;
  background-color: #ffffff;
  border-radius: 12px;
  box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
  text-align: center;
}

.title {
  font-size: 2.2rem;
  font-weight: bold;
  color: #333;
  margin-bottom: 2.5rem;
}

.input-group {
  margin-bottom: 1.5rem;
  text-align: left;
}

.input-group label {
  display: block;
  margin-bottom: 0.5rem;
  font-weight: 600;
  color: #555;
}

.input-group input {
  width: 100%;
  padding: 0.8rem 1rem;
  border: 1px solid #ddd;
  border-radius: 8px;
  font-size: 1rem;
  box-sizing: border-box;
  transition: border-color 0.3s, box-shadow 0.3s;
}

.input-group input:focus {
  outline: none;
  border-color: #007bff;
  box-shadow: 0 0 0 3px rgba(0, 123, 255, 0.2);
}

.login-button {
  width: 100%;
  padding: 1rem;
  border: none;
  border-radius: 8px;
  background-color: #007bff;
  color: white;
  font-size: 1.1rem;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s;
  margin-top: 1rem;
}

.login-button:hover {
  background-color: #0056b3;
}

.links {
  margin-top: 2rem;
  display: flex;
  justify-content: space-between;
  font-size: 0.9rem;
}

.links a {
  color: #007bff;
  text-decoration: none;
}

.links a:hover {
  text-decoration: underline;
}
</style>