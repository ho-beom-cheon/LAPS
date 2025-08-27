<template>
  <div class="my-page">
    <h1>마이페이지</h1>
    <div class="user-profile card">
      <h2>프로필 정보</h2>
      <div v-if="user" class="profile-details">
        <p><strong>이름:</strong> {{ user.name }}</p>
        <p><strong>이메일:</strong> {{ user.email }}</p>
        <p><strong>가입일:</strong> {{ user.joinDate }}</p>
        <button @click="editProfile">프로필 수정</button>
      </div>
      <div v-else>
        <p>사용자 정보를 불러오는 중입니다...</p>
      </div>
    </div>

    <div class="user-activity card">
      <h2>나의 활동</h2>
      <ul>
        <li><router-link to="/my-posts">내가 쓴 게시글</router-link></li>
        <li><router-link to="/my-comments">내가 쓴 댓글</router-link></li>
        <li><router-link to="/liked-posts">좋아요 한 게시글</router-link></li>
      </ul>
    </div>

    <div class="settings card">
        <h2>설정</h2>
        <ul>
            <li><router-link to="/settings/account">계정 설정</router-link></li>
            <li><router-link to="/settings/notifications">알림 설정</router-link></li>
        </ul>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';

// 실제 애플리케이션에서는 API를 통해 사용자 데이터를 가져와야 합니다.
// 이것은 임시 목(mock) 데이터입니다.
interface User {
  name: string;
  email: string;
  joinDate: string;
}

const user = ref<User | null>(null);
const router = useRouter();

onMounted(() => {
  // API에서 사용자 데이터를 가져오는 것을 시뮬레이션합니다.
  setTimeout(() => {
    user.value = {
      name: '홍길동',
      email: 'hong.gildong@example.com',
      joinDate: new Date().toLocaleDateString(),
    };
  }, 1000);
});

const editProfile = () => {
  // 프로필 수정 페이지로 이동합니다.
  router.push('/profile/edit');
};
</script>

<style scoped>
.my-page {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.card {
  /* 다크 모드에서 흰색 배경에 흰 글씨가 나오는 문제를 해결하기 위해 테마 변수를 사용합니다. */
  background-color: var(--color-background-soft);
  border: 1px solid var(--color-border);
  border-radius: 8px;
  padding: 20px;
  margin-bottom: 20px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
}

/* 헤더 색상도 테마를 따르도록 수정합니다. */
h1, h2 {
  color: var(--color-heading);
}

button {
  margin-top: 10px;
  padding: 8px 16px;
  cursor: pointer;
  border-radius: 4px;
  border: 1px solid transparent;
  background-color: hsla(160, 100%, 37%, 1);
  color: var(--vt-c-white);
  font-weight: 600;
  transition: background-color 0.2s;
}

ul {
  list-style: none;
  padding: 0;
}
</style>