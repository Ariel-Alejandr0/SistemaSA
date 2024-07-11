import React from 'react'
import Pla from '../../../assets/impressora3D/images/pla.png'
import Nylon from '../../../assets/impressora3D/images/nylon.png'
import Abs from '../../../assets/impressora3D/images/abs.png'
import PlaUltra from '../../../assets/impressora3D/images/pla_ultra.png'
import Hips from '../../../assets/impressora3D/images/HIPS.png'
import { handleOnClick } from '../../../functions/HandleOnClick'
import { useNavigate } from 'react-router-dom'

export default function EstoqueFilamento() {
    const navigate = useNavigate()

  return (
    <div class='corpo'>
    <div class="manufatura">
        <h1>Estoque de filamento</h1>
    </div>
    <div class="principal-container">
        <div class="card">
            <p>PLA 1,75mm</p>
            <img src={Pla} alt="PLA 1,75mm"/>
            <p>17,1 KG</p>
        </div>
        <div class="card">
            <p>Nylon 1,75mm</p>
            <img src={Nylon} alt="Nylon 1,75mm"/>
            <p>7 KG</p>
        </div>
        <div class="card">
            <p>ABS 1,75mm</p>
            <img src={Abs} alt="ABS 1,75mm"/>
            <p>10,3 KG</p>
        </div>
        <div class="card">
            <p>PLA Ultra Silk 2,80mm</p>
            <img src={PlaUltra} alt="PLA Ultra Silk 2,80mm"/>
            <p>3,7kg</p>
        </div>
        <div class="card">
            <p>HIPS 1,75mm</p>
            <img src={Hips} alt="HIPS 1,75mm"/>
            <p>4,2kg</p>
        </div>
    </div>
    <div class="voltar" id="back-button" onClick={(e) => handleOnClick(e, '/impressora-3d/verificar-estoque', navigate)}>
      <p>Voltar</p>
    </div>
    </div>
  )
}
