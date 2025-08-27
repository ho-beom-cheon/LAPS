import { createRouter, createWebHistory, type RouteRecordRaw } from 'vue-router';
import HomeView from '../views/HomeView.vue';
import Layout from '../components/Layout.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    component: Layout, // 모든 페이지의 기본 레이아웃으로 설정
    children: [
      { path: '', name: 'home', component: HomeView }, // 메인 페이지는 Layout 안에 렌더링
      {
        path: 'about',
        name: 'about',
        component: () => import('../views/AboutView.vue')
      },
      {
        path: 'loans',
        name: 'loans',
        component: () => import('../views/LoanProductsView.vue')
      },
      {
        path: 'login',
        name: 'login',
        component: () => import('../views/LoginView.vue')
      },
      {
        path: 'mypage',
        name: 'mypage',
        component: () => import('../views/MyPageView.vue')
      },
      {
        path: 'register',
        name: 'register',
        component: () => import('../views/RegisterView.vue')
      },
      {
        path: ':pathMatch(.*)*',
        name: 'NotFound',
        component: () => import('../views/NotFound.vue')
      }
    ]
  },
];

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes,
});

export default router;