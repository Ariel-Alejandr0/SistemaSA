import React from 'react'
import EstoquePecas from '../../../assets/impressora3D/images/estoque_peca.png'
import EstoqueFilamento from '../../../assets/impressora3D/images/estoque_filamento.png'

export default function VerificarEstoque() {
  return (
    <div class="corpo">
    <div class="manufatura">
        <h1>Verificar Estoque</h1>
    </div>
    <div class="principal-container">
            <div class="card">
                <p>Estoque de <br/> peças</p>
                <img src={EstoquePecas} alt="Estoque Pecas"/>
            </div>
            <div class="card">
                <p>Estoque de filamento</p>
                <img src={EstoqueFilamento} alt="Estoque Filamento"/>
            </div>
    </div>
    <a href="navbar-impressora-3d.html" class="back-button">Voltar</a>
</div>
  )
}
