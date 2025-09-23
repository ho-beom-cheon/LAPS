<template>
  <div class="register-container">
    <div class="register-form-wrapper">
      <h2>회원가입</h2>
      <p>LAPS에 오신 것을 환영합니다.</p> <p>정보를 입력해주세요.</p>
      <form @submit.prevent="handleSubmit">
        <div class="form-group">
          <label for="username">아이디</label>
          <div class="input-with-button">
            <input type="text" id="username" v-model="formData.username" @input="resetUsernameCheck" required placeholder="아이디를 입력하세요">
            <button type="button" @click="checkUsernameDuplication" class="check-button">중복 확인</button>
          </div>
          <p v-if="usernameCheckMessage" :class="['check-message', { 'success': isUsernameAvailable, 'error': !isUsernameAvailable && isUsernameChecked }]">
            {{ usernameCheckMessage }}
          </p>
        </div>
        <div class="form-group">
          <label for="password">비밀번호</label>
          <input type="password" id="password" v-model="formData.password" required placeholder="비밀번호를 입력하세요">
        </div>
        <div class="form-group">
          <label for="confirmPassword">비밀번호 확인</label>
          <input type="password" id="confirmPassword" v-model="formData.confirmPassword" required placeholder="비밀번호를 다시 입력하세요">
        </div>
        <div class="form-group">
          <label for="name">이름</label>
          <input type="text" id="name" v-model="formData.name" required placeholder="이름을 입력하세요">
        </div>
        <div class="form-group">
          <label for="email">이메일</label>
          <input type="email" id="email" v-model="formData.email" required placeholder="이메일 주소를 입력하세요">
        </div>
        <div class="form-group">
          <label for="phone">휴대폰 번호</label>
          <input type="tel" id="phone" v-model="formData.phone" required placeholder="'-' 없이 숫자만 입력하세요">
        </div>
        <button type="submit" class="submit-button" :disabled="!isUsernameAvailable">가입하기</button>
      </form>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue';
import { useRouter } from 'vue-router';
import axios from 'axios';

const router = useRouter();

const formData = ref({
  username: '',
  password: '',
  confirmPassword: '',
  name: '',
  email: '',
  phone: '',
});

const isUsernameChecked = ref(false);
const isUsernameAvailable = ref(false);
const usernameCheckMessage = ref('');

// 아이디 중복 확인 함수
const checkUsernameDuplication = async () => {
  const username = formData.value.username.trim();
  if (!username) {
    alert('아이디를 입력해주세요.');
    return;
  }

  try {
    const response = await axios.get(`/api/members/check-username`, { params: { username } });
    const isAvailable = response.data.available;

    isUsernameChecked.value = true;
    if (isAvailable) {
      isUsernameAvailable.value = true;
      usernameCheckMessage.value = '사용 가능한 아이디입니다.';
    } else {
      isUsernameAvailable.value = false;
      usernameCheckMessage.value = '이미 사용 중인 아이디입니다.';
    }
  } catch (error) {
    console.error('Error checking username:', error);
    usernameCheckMessage.value = '중복 확인 중 오류가 발생했습니다. 다시 시도해주세요.';
    isUsernameAvailable.value = false;
  }
};

// 사용자가 아이디를 수정하면 중복 확인 상태를 리셋
const resetUsernameCheck = () => {
  if (isUsernameChecked.value) {
    isUsernameChecked.value = false;
    isUsernameAvailable.value = false;
    usernameCheckMessage.value = '';
  }
};

const handleSubmit = async () => {
  if (!isUsernameChecked.value || !isUsernameAvailable.value) {
    alert('아이디 중복 확인을 해주세요.');
    return;
  }

  if (formData.value.password !== formData.value.confirmPassword) {
    alert('비밀번호가 일치하지 않습니다.');
    return;
  }

  try {
    const payload = {
      username: formData.value.username,
      password: formData.value.password,
      name: formData.value.name,
      email: formData.value.email,
      phone: formData.value.phone,
    };
    await axios.post('/api/members/signup', payload);
    alert('회원가입이 완료되었습니다. 로그인 페이지로 이동합니다.');
    router.push('/login');
  } catch (error) {
    console.error('회원가입 실패:', error);
    const errorMessage = axios.isAxiosError(error) && error.response?.data?.message
      ? error.response.data.message
      : '회원가입 중 오류가 발생했습니다.';
    alert(`회원가입 실패: ${errorMessage}`);
  }
};
</script>

<style scoped>
.register-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background-color: #f4f7f6;
}

.register-form-wrapper {
  background-color: white;
  padding: 3rem;
  border-radius: 12px;
  box-shadow: 0 8px 16px rgba(0,0,0,0.1);
  width: 100%;
  max-width: 500px;
  text-align: center;
}

h2 {
  font-size: 2rem;
  color: #333;
  margin-bottom: 1rem;
}

.register-form-wrapper > p {
  color: #666;
  margin-bottom: 1rem;
}

.form-group {
  margin-bottom: 1.5rem;
  text-align: left;
}

.form-group label {
  display: block;
  margin-bottom: 0.5rem;
  font-weight: 600;
  color: #555;
}

.form-group input {
  width: 100%;
  padding: 0.8rem 1rem;
  border: 1px solid #ddd;
  border-radius: 6px;
  font-size: 1rem;
  box-sizing: border-box;
}

.input-with-button {
  display: flex;
  gap: 0.5rem;
}

.input-with-button input {
  flex-grow: 1;
}

.check-button {
  padding: 0.8rem 1rem;
  background-color: #6c757d;
  color: white;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  white-space: nowrap; /* 버튼 텍스트가 줄바꿈되지 않도록 */
  font-size: 0.9rem;
  transition: background-color 0.2s;
}

.check-button:hover {
  background-color: #5a6268;
}

.check-message {
  font-size: 0.9rem;
  margin-top: 0.5rem;
  height: 1rem; /* 메시지 영역 높이 고정 */
}

.check-message.success {
  color: #28a745;
}

.check-message.error {
  color: #dc3545;
}

.submit-button {
  width: 100%;
  padding: 1rem;
  background-color: #007bff;
  color: white;
  border: none;
  border-radius: 6px;
  font-size: 1.1rem;
  font-weight: bold;
  cursor: pointer;
  transition: background-color 0.3s;
}

.submit-button:hover:not(:disabled) {
  background-color: #0056b3;
}

.submit-button:disabled {
  background-color: #a0c7e4;
  cursor: not-allowed;
}
</style>