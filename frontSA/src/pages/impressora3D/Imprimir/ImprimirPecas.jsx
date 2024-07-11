import React from 'react'
import VerificarMoldes from '../../../assets/impressora3D/images/verificar_moldes.png'
import FazerPeca from '../../../assets/impressora3D/images/propria_peca.png'
import { handleOnClick } from '../../../functions/HandleOnClick'
import { useNavigate } from 'react-router-dom'

export default function ImprimirPecas() {
  const navigate = useNavigate()
  return (
    <div class="corpo">
    <div class="manufatura">
        <h1>Imprimir Peça</h1>
    </div>
    <div class="principal-container"> 
            <div class="card" onClick={(e) => handleOnClick(e, '/impressora-3d/verificar-moldes', navigate)}>
                <p>Verificar moldes</p>
                <img src={VerificarMoldes} alt="verificar Moldes"/>
            </div>
            <div class="card" onClick={(e) => handleOnClick(e, '/impressora-3d/imprimir-propria-peca', navigate)}>
                <p>Fazer própria peça</p>
                <img src={FazerPeca} alt="fazer peca"/>
            </div>
    </div>
    <div class="voltar" id="back-button" onClick={(e) => handleOnClick(e, '/impressora-3d/servicos-3d', navigate)}>
      <p>Voltar</p>
    </div>
</div>
  )
}
