import React from 'react'
import { useNavigate } from 'react-router-dom'


export default function ListarErros() {
  const navigate = useNavigate()
  function handleOnClick(e) {
     
      e.preventDefault()
      navigate("/qualidade/gerar-relatorio")
  }


  return (
    <div style={{width: '100%', height: '100%', display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
        <div  class="container">
            <h1>Listar Erros</h1>
            <form id="formListaErros">
                <div id="errosContainer"></div>
                <button type="button" id="adicionarErro">Adicionar Erro</button>
                <button type="submit" onClick={handleOnClick} >Próximo</button>
            </form>
        </div>
        <script src="scripts.js"></script>
    </div>
  )
}

