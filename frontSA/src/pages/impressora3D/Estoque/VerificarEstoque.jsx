import React from 'react'
import EstoquePecas from '../../../assets/impressora3D/images/estoque_peca.png'
import EstoqueFilamento from '../../../assets/impressora3D/images/estoque_filamento.png'
import { handleOnClick } from '../../../functions/HandleOnClick'
import { useNavigate } from 'react-router-dom'

export default function VerificarEstoque() {
  const navigate = useNavigate()

  return (
    <div class="corpo">
    <div class="manufatura">
        <h1>Verificar Estoque</h1>
    </div>
    <div class="principal-container">
            <div class="card" onClick={(e) => handleOnClick(e, '/impressora-3d/estoque-peca', navigate)}>
                <p>Estoque de <br/> peças</p>
                <img src={EstoquePecas} alt="Estoque Pecas"/>
            </div>
            <div class="card" onClick={(e) => handleOnClick(e, '/impressora-3d/estoque-filamento', navigate)}>
                <p>Estoque de filamento</p>
                <img src={EstoqueFilamento} alt="Estoque Filamento"/>
            </div>
    </div>
    <div class="voltar" id="back-button" onClick={(e) => handleOnClick(e, '/impressora-3d/servicos-3d', navigate)}>
      <p>Voltar</p>
    </div>
</div>
  )
}
