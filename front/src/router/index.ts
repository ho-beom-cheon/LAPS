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
        path: ':pathMatch(.*)*',
        name: 'NotFound',
        component: () => import('../views/NotFound.vue')
      }
    ]
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;