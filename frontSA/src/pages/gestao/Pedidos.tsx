import React from 'react';
import '../../styles/pages/Gestao/pedidos.css'
import { useNavigate } from 'react-router-dom'
import { handleOnClick } from '../../functions/HandleOnClick'

export default function Pedidos() {
  const navigate = useNavigate()
  
  return (
    <div style={{width: '100%', height: '100%', display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
      <div className="container">
          <h1>Pedidos</h1>
          <div className='buttons'>
                <button type="submit"  >Ver Pedidos</button>
                <button  id="relatorioss">Fazer Pedido</button>
          </div>
      </div>
    </div>
  );
}
