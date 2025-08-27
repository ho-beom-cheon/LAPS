import React from 'react';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="app-header">
        <h1>LAPS 프로젝트</h1>
      </header>
      <main className="main-content">
        <h2>대출 상품 목록</h2>
        <div className="card-container">
          <div className="card">
            <h3>신용 대출</h3>
            <p>빠르고 간편한 신용 대출 상품입니다.</p>
          </div>
          <div className="card">
            <h3>주택 담보 대출</h3>
            <p>안정적인 금리의 주택 담보 대출.</p>
          </div>
          <div className="card">
            <h3>자동차 대출</h3>
            <p>내 차 마련을 위한 최적의 선택.</p>
          </div>
          <div className="card">
            <h3>전세자금 대출</h3>
            <p>새로운 보금자리를 위한 든든한 지원.</p>
          </div>
          <div className="card">
            <h3>사업자 대출</h3>
            <p>사장님들의 성공을 응원합니다.</p>
          </div>
        </div>
      </main>
    </div>
  );
}

export default App;