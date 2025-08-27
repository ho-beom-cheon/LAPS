<template>
  <div class="home-container">
    <section class="hero-section">
      <h1>안전하고 믿을 수 있는 P2P 금융 서비스</h1>
      <p>낮은 금리로 대출받고, 소액으로 투자하며 재테크를 시작하세요.</p>
      <div class="cta-buttons">
        <router-link to="/loans" class="cta-button primary">대출 상품 보기</router-link>
        <router-link to="/invest" class="cta-button secondary">투자 상품 보기</router-link>
      </div>
    </section>

    <section class="features-section">
      <h2>서비스 주요 특징</h2>
      <div class="features-grid">
        <div class="feature-card">
          <h3>✅ 간편한 신청</h3>
          <p>복잡한 서류 없이 온라인으로 쉽고 빠르게 신청하세요.</p>
        </div>
        <div class="feature-card">
          <h3>📈 합리적인 금리</h3>
          <p>투자자와 대출자를 직접 연결하여 합리적인 금리를 제공합니다.</p>
        </div>
        <div class="feature-card">
          <h3>🔒 안전한 투자</h3>
          <p>분산 투자를 통해 위험을 줄이고 안정적인 수익을 추구합니다.</p>
        </div>
      </div>
    </section>

    <section class="stats-section">
      <h2>운영 현황</h2>
      <div class="stats-grid">
        <div class="stat-card">
          <h3>누적 대출액</h3>
          <p><strong>1,250억</strong> 원</p>
        </div>
        <div class="stat-card">
          <h3>참여 투자자 수</h3>
          <p><strong>50,000</strong> 명</p>
        </div>
      </div>
    </section>
  </div>
</template>

<script setup>
// 필요한 스크립트 로직
</script>

<style scoped>
.home-container {
  text-align: center;
}
.hero-section {
  background-color: #f0f8ff;
  padding: 5rem 2rem;
  border-radius: 8px;
}
.hero-section h1 {
  font-size: 2.5rem;
  color: #333;
}
.hero-section p {
  font-size: 1.2rem;
  color: #666;
}
.cta-buttons {
  margin-top: 2rem;
}
.cta-button {
  padding: 0.8rem 1.5rem;
  border-radius: 5px;
  font-size: 1rem;
  text-decoration: none;
  margin: 0 0.5rem;
  transition: background-color 0.3s;
}
.tertiary {
  background-color: #fff;
  color: #007bff;
  border: 1px solid #007bff;
}
.primary {
  background-color: #007bff;
  color: white;
}
.secondary {
  background-color: #6c757d;
  color: white;
}
.features-section, .stats-section {
  padding: 3rem 0;
}
h2 {
  font-size: 2rem;
  margin-bottom: 2rem;
}
.features-grid, .stats-grid {
  display: grid;
  gap: 2rem;
  max-width: 900px;
  margin: 0 auto;
}
.features-grid {
  grid-template-columns: repeat(3, 1fr);
}
.stats-grid {
  grid-template-columns: repeat(2, 1fr);
}
.feature-card, .stat-card {
  background-color: #f9f9f9;
  border: 1px solid #ddd;
  color: #333;
  padding: 2rem;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0,0,0,0.1);
}
.stat-card h3 {
  color: #007bff;
  font-size: 1.5rem;
}
.stat-card strong {
  font-size: 2.5rem;
  color: #333;
}

/* 모바일 반응형 스타일 */
@media (max-width: 768px) {
  .hero-section {
    padding: 3rem 1.5rem;
  }

  .hero-section h1 {
    font-size: 2rem;
  }

  .hero-section p {
    font-size: 1.1rem;
  }

  .cta-buttons {
    display: flex;
    flex-direction: column;
    gap: 1rem;
    align-items: center;
  }

  .cta-button {
    margin: 0;
  }

  .cta-button {
    width: 80%;
  }

  .features-grid, .stats-grid {
    grid-template-columns: 1fr;
  }
}
</style>