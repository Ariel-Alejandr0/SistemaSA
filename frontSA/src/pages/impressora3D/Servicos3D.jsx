import React from 'react'
import Verificar from '../../assets/impressora3D/icon/verificar.png'
import Estoque from '../../assets/impressora3D/icon/estoque.png'
import Impressora from '../../assets/impressora3D/icon/impressora-3d.png'
import Pedido from '../../assets/impressora3D/icon/pedido-online.png'
import '../../styles/pages/impressora3D/styles.css'
import { useNavigate } from 'react-router-dom'




export default function Servicos3D() {
    const navigate = useNavigate()


  function handleOnClick(e) {
    e.preventDefault()
    navigate("/impressora-3d/estoque")
  }
  return (
    <div class="corpo">
    <div class="manufatura">
        <a href="../menu-empresas/index.html">
            <h1>Manufatura Aditiva 3D</h1>
        </a>
    </div>
    <div class="principal-container">
            <div class="card" id="verificar-estoque" onClick={handleOnClick}>
                <p>Verificar estoque</p>
                <img src={Estoque} alt="Verificar Estoque"/>
            </div>
        <a href="imprimir_peca.html">
            <div class="card" id="imprimir-peca">
                <p>Imprimir peça</p>
                <img src={Impressora} alt="Imprimir Peça"/>
            </div>
        </a>
        <a href="fazer_pedido.html">
            <div class="card" id="fazer-pedido">
                <p>Fazer pedido</p>
                <img src={Pedido} alt="Fazer Pedido"/>
            </div>
        </a>
        <a href="verificar oms1.html">
            <div class="card" id="verificar-oms">
                <p>Verificar OMS</p>
                <img src={Verificar} alt="Verificar OMS"/>
            </div>
        </a>
    </div>
    <button class="back-button">
        <a href="../menu-empresas/index.html">
            <h3>Voltar</h3>
        </a>
    </button>
</div>
  )
}
