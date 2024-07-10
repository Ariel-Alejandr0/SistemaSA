import React from 'react'
import PecasFornecedor from '../../../assets/impressora3D/images/path-to-icon-fornecedor.png'
import Filamento from '../../../assets/impressora3D/images/path-to-icon-filamento.png'

export default function FazerPedido() {
  return (
    <div class="corpo">
    <div class="manufatura">
        <h1>Fazer Pedido</h1>
    </div>
    <div class="principal-container">
            <div class="card">
                <p>Pedir peças ao <br/> fornecedor</p>
                <img src={PecasFornecedor} alt="Pecas Fornecedor"/>
            </div>
            <div class="card">
                <p>Pedir filamento</p>
                <img src={Filamento} alt="Pedir Filamento"/>
            </div>
    </div>
    <a href="navbar-impressora-3d.html" class="back-button">Voltar</a>
</div>
  )
}
