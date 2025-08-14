<template>
  <div class="loan-products-container">
    <h1 class="page-title">대출 상품 목록</h1>
    <p class="page-description">
      고객님의 필요에 맞는 다양한 대출 상품을 확인해보세요.
    </p>

    <div class="loan-grid">
      <div v-for="product in loanProducts" :key="product.id" class="loan-card">
        <div class="card-header">
          <h3>{{ product.name }}</h3>
        </div>
        <div class="card-body">
          <ul>
            <li>
              <strong>금리:</strong>
              <span>{{ product.interestRate }}</span>
            </li>
            <li>
              <strong>기간:</strong>
              <span>{{ product.period }}</span>
            </li>
            <li>
              <strong>한도:</strong>
              <span>{{ product.limit }}</span>
            </li>
          </ul>
          <p class="product-description">{{ product.description }}</p>
        </div>
        <div class="card-footer">
          <button class="details-button">자세히 보기</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';

const loanProducts = ref([
  {
    id: 1,
    name: '직장인 신용대출',
    interestRate: '연 4.5% ~ 12.0%',
    period: '최대 84개월',
    limit: '최대 2억원',
    description: '안정적인 소득이 있는 직장인을 위한 맞춤 신용대출 상품입니다.'
  },
  {
    id: 2,
    name: '사업자 대출',
    interestRate: '연 5.8% ~ 15.5%',
    period: '최대 60개월',
    limit: '최대 3억원',
    description: '개인 사업자의 사업 운영 자금을 위한 대출 상품입니다.'
  },
  {
    id: 3,
    name: '프리랜서 대출',
    interestRate: '연 6.2% ~ 17.0%',
    period: '최대 48개월',
    limit: '최대 5천만원',
    description: '소득 증빙이 어려운 프리랜서를 위한 간편 대출 상품입니다.'
  },
  {
    id: 4,
    name: '자동차 담보대출',
    interestRate: '연 3.9% ~ 11.5%',
    period: '최대 72개월',
    limit: '차량 시세의 110%',
    description: '소유하고 계신 차량을 담보로 더 낮은 금리의 혜택을 받으세요.'
  }
]);
</script>

<style scoped>
.loan-products-container {
  width: 100%;
}

.page-title {
  font-size: 2.5rem;
  color: #333;
  text-align: center;
  margin-bottom: 1rem;
}

.page-description {
  font-size: 1.2rem;
  color: #666;
  text-align: center;
  margin-bottom: 4rem;
}

.loan-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 2.5rem;
}

.loan-card {
  background-color: #ffffff;
  border: 1px solid #e0e0e0;
  border-radius: 12px;
  box-shadow: 0 6px 12px rgba(0, 0, 0, 0.08);
  display: flex;
  flex-direction: column;
  transition: transform 0.3s ease, box-shadow 0.3s ease;
}

.loan-card:hover {
  transform: translateY(-8px);
  box-shadow: 0 12px 24px rgba(0, 0, 0, 0.12);
}

.card-header {
  background-color: #007bff;
  color: white;
  padding: 1.5rem;
  border-top-left-radius: 12px;
  border-top-right-radius: 12px;
}

.card-header h3 {
  margin: 0;
  font-size: 1.5rem;
  text-align: center;
}

.card-body {
  padding: 2rem;
  flex-grow: 1;
}

.card-body ul {
  list-style: none;
  padding: 0;
  margin: 0 0 1.5rem 0;
}

.card-body li {
  display: flex;
  justify-content: space-between;
  padding: 0.8rem 0;
  border-bottom: 1px solid #f0f0f0;
  font-size: 1.1rem;
}

.card-body li:last-child {
  border-bottom: none;
}

.card-body li strong {
  color: #333;
}

.card-body li span {
  color: #0056b3;
  font-weight: bold;
}

.product-description {
  font-size: 1rem;
  color: #777;
  line-height: 1.6;
  margin-top: 1.5rem;
}

.card-footer {
  padding: 1.5rem 2rem;
  background-color: #f9f9f9;
  border-bottom-left-radius: 12px;
  border-bottom-right-radius: 12px;
  text-align: center;
}

.details-button {
  background-color: #28a745;
  color: white;
  border: none;
  padding: 0.8rem 1.5rem;
  border-radius: 5px;
  font-size: 1.1rem;
  font-weight: bold;
  cursor: pointer;
  width: 100%;
  transition: background-color 0.3s ease;
}

.details-button:hover {
  background-color: #218838;
}
</style>