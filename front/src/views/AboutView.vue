<template>
  <div class="about-container">
    <h1 class="page-title">회사 소개</h1>

    <section class="about-section">
      <h2>서비스 정보</h2>
      <div class="card">
        <p>
          P2P Project는 개인과 개인을 연결하여 더 나은 금융 기회를 제공하는 혁신적인 P2P 금융 플랫폼입니다.
          저희는 기술을 통해 복잡한 금융 절차를 간소화하고, 대출자에게는 합리적인 금리를, 투자자에게는 안정적인 수익을 제공하는 것을 목표로 합니다.
        </p>
      </div>
    </section>

    <section class="about-section">
      <h2>회사 비전</h2>
      <div class="card">
        <p>
          모두가 신뢰할 수 있는 투명하고 공정한 금융 생태계를 만드는 것입니다.
          저희는 고객의 성공이 곧 우리의 성공이라는 믿음으로, 항상 고객의 입장에서 생각하고 최고의 서비스를 제공하기 위해 노력합니다.
        </p>
      </div>
    </section>

    <section class="about-section">
      <h2>연락처 및 주소</h2>
      <div class="card">
        <ul>
          <li><strong>이메일:</strong> contact@p2pproject.com</li>
          <li><strong>전화번호:</strong> 02-1234-5678</li>
          <li><strong>주소:</strong> 서울특별시 강남구 테헤란로 123, P2P 빌딩 10층</li>
        </ul>
      </div>
    </section>

    <section class="about-section">
      <h2>버전 정보</h2>
      <div class="card">
        <p>현재 버전: {{ appVersion }}</p>
      </div>
    </section>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const appVersion = ref('1.0.0');
</script>

<style scoped>
.page-title {
  font-size: 2.5rem;
  color: #333;
  text-align: center;
  margin-bottom: 3rem;
}

.about-section {
  margin-bottom: 2.5rem;
}

.about-section h2 {
  font-size: 1.8rem;
  color: #007bff;
  border-bottom: 2px solid #007bff;
  padding-bottom: 0.5rem;
  margin-bottom: 1.5rem;
}

.card {
  background-color: #f9f9f9;
  border: 1px solid #ddd;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0,0,0,0.05);
}

.card p, .card ul {
  font-size: 1.1rem;
  line-height: 1.8;
  color: #555;
}

.card ul {
  list-style: none;
  padding: 0;
}

.card li {
  margin-bottom: 0.8rem;
}

.card li strong {
  color: #333;
  margin-right: 0.5rem;
}
</style>
