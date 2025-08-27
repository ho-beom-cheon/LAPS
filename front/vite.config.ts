import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import Inspect from 'vite-plugin-inspect'
import vueDevTools from 'vite-plugin-vue-devtools'

// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
    Inspect(), // 추가
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    },
  },
  server: {
    host: '0.0.0.0', // 모든 네트워크 인터페이스에서 서버를 수신 대기하도록 설정
    allowedHosts: [
      // ngrok 호스트를 허용 목록에 추가합니다.
      '.ngrok-free.app'
    ],
    // API 요청을 백엔드로 프록시 설정
    proxy: {
      // '/api'로 시작하는 요청을 백엔드로 전달
      '/api': {
        target: 'http://localhost:8080', // Spring Boot 백엔드 주소
        changeOrigin: true, // CORS 오류 방지를 위해 호스트 헤더를 변경
      },
    },
  },
})
