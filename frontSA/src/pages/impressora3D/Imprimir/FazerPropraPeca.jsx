import React from 'react';
import { handleOnClick } from '../../../functions/HandleOnClick';
import { useNavigate } from 'react-router-dom';

export default function FazerPropraPeca() {
  const navigate = useNavigate();

  return (
    <div className='corpo'>
      <div className="manufatura">
        <h1>Fazer própria peça</h1>
      </div>
      <div className="container-peca">
        <label htmlFor="filamento">Tipo filamento</label>
        <select id="filamento">
          <option value="" disabled defaultValue>Selecione</option>
          <option value="filamento1">PLA 1,75mm</option>
          <option value="filamento2">Nylon 1,75mm</option>
          <option value="filamento3">ABS 1,75mm</option>
          <option value="filamento4">PLA Ultra Silk 2,80mm</option>
          <option value="filamento5">HIPS 1,75mm</option>
        </select>
        <label htmlFor="tamanho">Tamanho</label>
        <input type="text" id="tamanho" placeholder="Digite o tamanho" />
        <button className="btn imprimir">Imprimir</button>
        
      </div>
      
      <div className="voltar" id="back-button" onClick={(e) => handleOnClick(e, '/impressora-3d/imprimir-peca', navigate)}>
        <p>Voltar</p>
      </div>
    </div>
  );
}
