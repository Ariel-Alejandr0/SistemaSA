import React from 'react'
import PecasFornecedor from '../../../assets/impressora3D/images/fornecedor.png'
import Filamento from '../../../assets/impressora3D/images/filamento.png'
import { handleOnClick } from '../../../functions/HandleOnClick'
import { useNavigate } from 'react-router-dom'

export default function FazerPedido() {
  const navigate = useNavigate()

  return (
    <div class="corpo">
    <div class="manufatura">
        <h1>Fazer Pedido</h1>
    </div>
    <div class="principal-container">
            <div class="card" onClick={(e) => handleOnClick(e, '/impressora-3d/pedir-fornecedor', navigate)}>
                <p>Pedir peças ao <br/> fornecedor</p>
                <img src={PecasFornecedor} alt="Pecas Fornecedor"/>
            </div>
            <div class="card" onClick={(e) => handleOnClick(e, '/impressora-3d/pedir-filamento', navigate)}>
                <p>Pedir filamento</p>
                <img src={Filamento} alt="Pedir Filamento"/>
            </div>
    </div>
    <div class="voltar" id="back-button" onClick={(e) => handleOnClick(e, '/impressora-3d/servicos-3d', navigate)}>
      <p>Voltar</p>
    </div>
</div>
  )
}
