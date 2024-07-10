import React from 'react'
import VerificarMoldes from '../../../assets/impressora3D/images/verificar_moldes.png'
import FazerPeca from '../../../assets/impressora3D/images/propria_peca.png'


export default function ImprimirPecas() {
  return (
    <div class="corpo">
    <div class="manufatura">
        <h1>Imprimir Peça</h1>
    </div>
    <div class="principal-container"> 
            <div class="card">
                <p>Verificar moldes</p>
                <img src={VerificarMoldes} alt="verificar Moldes"/>
            </div>
            <div class="card">
                <p>Fazer própria peça</p>
                <img src={FazerPeca} alt="verificar Moldes"/>
            </div>
    </div>
    <a href="navbar-impressora-3d.html" class="back-button">Voltar</a>
</div>
  )
}
