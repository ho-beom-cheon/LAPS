import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/HomeView.vue';
import Layout from '../components/Layout.vue';

const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout, // 모든 페이지의 기본 레이아웃으로 설정
    children: [
      { path: '', name: 'Home', component: Home }, // 메인 페이지는 Layout 안에 렌더링
      // 여기에 다른 페이지 라우트를 추가합니다.
      // { path: '/loans', name: 'Loans', component: () => import('../views/Loans.vue') },
      // { path: '/mypage', name: 'MyPage', component: () => import('../views/MyPage.vue') },
      // { path: '/login', name: 'Login', component: () => import('../views/Login.vue') },
    ]
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;