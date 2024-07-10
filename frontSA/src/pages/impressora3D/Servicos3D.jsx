import React from 'react'
import Verificar from '../../assets/impressora3D/icons/verificar.png'
import Estoque from '../../assets/impressora3D/icons/estoque.png'
import Impressora from '../../assets/impressora3D/icons/impressora-3d.png'
import Pedido from '../../assets/impressora3D/icons/pedido-online.png'
import '../../styles/pages/impressora3D/styles.css'
import { useNavigate } from 'react-router-dom'




export default function Servicos3D() {
    const navigate = useNavigate()

  function handleOnClickEstoque(e) {
    e.preventDefault()
    navigate("/impressora-3d/verificar-estoque")
  }

  function handleOnClickImprimir(e) {
    e.preventDefault()
    navigate("/impressora-3d/imprimir-peca")
  }

  function handleOnClickPedido(e) {
    e.preventDefault()
    navigate("/impressora-3d/fazer-pedido")
  }

  function handleOnClickOms(e) {
    e.preventDefault()
    navigate("/impressora-3d/verificar-oms")
  }

  function handleOnClickVoltar(e) {
    e.preventDefault()
    navigate("")
  }

  return (
    <div class="corpo">
    <div class="manufatura">
        <a href="../menu-empresas/index.html">
            <h1>Manufatura Aditiva 3D</h1>
        </a>
    </div>
    <div class="principal-container">
            <div class="card" id="verificar-estoque" onClick={handleOnClickEstoque}>
                <p>Verificar estoque</p>
                <img src={Estoque} alt="Verificar Estoque"/>
            </div>
            <div class="card" id="imprimir-peca" onClick={handleOnClickImprimir}>
                <p>Imprimir peça</p>
                <img src={Impressora} alt="Imprimir Peça"/>
            </div>
            <div class="card" id="fazer-pedido" onClick={handleOnClickPedido}>
                <p>Fazer pedido</p>
                <img src={Pedido} alt="Fazer Pedido"/>
            </div>  
            <div class="card" id="verificar-oms" onClick={handleOnClickOms}>
                <p>Verificar OMS</p>
                <img src={Verificar} alt="Verificar OMS"/>
            </div>
    </div>
    <button class="back-button">
        <a href="../menu-empresas/index.html">
            <h3>Voltar</h3>
        </a>
    </button>
</div>
  )
}
