import React from 'react';
import '../../styles/pages/monitoramentoMaquinas/home.css'

export default function ProgressBar({ qtdProd, qtdPlan }) {
  return (
    <div>
      <p>Qtd. produzida / Qtd. planejada</p>
      <div className="progress">
        <div className="progress-bar" style={{ width: `${(qtdProd / qtdPlan) * 100}%` }}></div>
      </div>
      <p>{qtdProd} / {qtdPlan}</p>
    </div>
  );
}
