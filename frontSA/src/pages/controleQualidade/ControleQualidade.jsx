import React from 'react'
import '../../styles/pages/ControleQualidade/controlequalidade.css'
import { useNavigate } from 'react-router-dom'
import { handleOnClick } from '../../functions/HandleOnClick'


export default function ControleQualidade() {
  /* const navigate = useNavigate()
  function handleOnClick(e) {
     
      e.preventDefault()
      navigate("/qualidade/quantidade-erros")
  } */


  const navigate = useNavigate()


  return (
    <div style={{width: '100%', height: '100%', display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
      <div className="container">
          <h1>Informar ID do Lote</h1>
          <form id="formID">
              <label >ID do Lote:</label>
              <input type="text" id="idLote" name="idLote" required />
              <button type="submit" onClick={(e) => handleOnClick(e, '/qualidade/quantidade-erros', navigate)} >Próximo</button>
              <button  id="relatorioss" onClick={(e) => handleOnClick(e, '/qualidade/relatorios-salvos', navigate)} >Ver Relatórios Salvos</button>
          </form>
      </div>
    </div>
  )
}
