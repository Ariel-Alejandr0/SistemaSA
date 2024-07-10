import React from 'react'
import { handleOnClick } from '../../../functions/HandleOnClick'
import { useNavigate } from 'react-router-dom'

export default function RelatoriosSalvos() {
    const navigate = useNavigate()

  return (
    <div>
        <div className="container">
            <h1>Relatórios Salvos</h1>
            <div id="relatoriosContainer"></div>
            <button onClick={(e) => handleOnClick(e, '/qualidade/home-qualidade', navigate)} >Voltar</button>
        </div>
    </div>
  )
}
