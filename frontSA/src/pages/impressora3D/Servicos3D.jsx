import React from 'react'
import Verificar from '../../assets/impressora3D/icons/verificar.png'
import Estoque from '../../assets/impressora3D/icons/estoque.png'
import Impressora from '../../assets/impressora3D/icons/impressora-3d.png'
import Pedido from '../../assets/impressora3D/icons/pedido-online.png'
import '../../styles/pages/impressora3D/styles.css'
import { useNavigate } from 'react-router-dom'
import { handleOnClick } from '../../functions/HandleOnClick' 



export default function Servicos3D() {
    const navigate = useNavigate()

  return (
    <div class="corpo">
      <div class="manufatura">
        <h1>Manufatura Aditiva 3D</h1>
      </div>
    <div class="principal-container">
            <div class="card" id="verificar-estoque" onClick={(e) => handleOnClick(e, '/impressora-3d/verificar-estoque', navigate)}>
                <p>Verificar estoque</p>
                <img src={Estoque} alt="Verificar Estoque"/>
            </div>
            <div class="card" id="imprimir-peca" onClick={(e) => handleOnClick(e, '/impressora-3d/imprimir-peca', navigate)}>
                <p>Imprimir peça</p>
                <img src={Impressora} alt="Imprimir Peça"/>
            </div>
            <div class="card" id="fazer-pedido" onClick={(e) => handleOnClick(e, '/impressora-3d/fazer-pedido', navigate)}>
                <p>Fazer pedido</p>
                <img src={Pedido} alt="Fazer Pedido"/>
            </div>  
            <div class="card" id="verificar-oms" onClick={(e) => handleOnClick(e, '/impressora-3d/verificar-oms', navigate)}>
                <p>Verificar OMS</p>
                <img src={Verificar} alt="Verificar OMS"/>
            </div>
    </div>
</div>
  )
}
