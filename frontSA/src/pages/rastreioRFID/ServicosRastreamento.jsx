import React from 'react'
import iconlogo from '../../assets/rastreio/images/iconlogo.png'
import iconlocalizacao from '../../assets/rastreio/images/iconlocalização.png'
import iconenvio from '../../assets/rastreio/images/icon_envio.png'
import { useNavigate } from 'react-router-dom'
import { handleOnClick } from '../../functions/HandleOnClick'

export default function ServicosRastreamento() {
  const navigate = useNavigate()

  return (
    <div>
      <div class="container">
        <img class="iconlogo" src={iconlogo} alt="Icon" />
        <div onClick={(e) => handleOnClick(e, '/qualidade/quantidade-erros', navigate)} class="button">
            <img src={iconlocalizacao} alt="Track Icon" />
            Quero Rastrear Minha Encomenda
            <img src={iconlocalizacao} alt="Track Icon" />
        </div>
        <div onClick={(e) => handleOnClick(e, '/qualidade/quantidade-erros', navigate)} class="button">
            <img src={iconenvio} alt="Send Icon" />
            Quero Enviar
            <img src={iconenvio} alt="Send Icon" />
        </div>
      </div>
    </div>
  )
}
