import React from 'react'
import { useNavigate } from 'react-router-dom'

export default function QuantidadeErros() {
  const navigate = useNavigate() 
  function handleOnClick(e) {
      
      e.preventDefault()
      navigate("/qualidade/listar-erros")
  }
  return (
    <div style={{width: '100%', height: '100%', display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
        <div className="container" >
            <h1>Verificar Erros</h1>
            <form id="formErros">
                <label >Quantidade de Produtos com Erros:</label>
                <input type="number" id="quantidadeErros" name="quantidadeErros" required />
            <button type="submit" onClick={handleOnClick} >Próximo</button>
            </form>
        </div>
    </div>
  )
}
