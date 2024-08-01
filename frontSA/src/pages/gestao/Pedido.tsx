import React from 'react'

export default function FazerPedido() {
  return (
    <div style={{width: '100%', height: '100%', display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
      <div className="container">
          <h1>Informar ID do Lote</h1>
          <form id="formID">
              <label >ID do Lote:</label>
              <input type="text" id="idLote" name="idLote" required />
              <button type="submit"  >Próximo</button>
              <button  id="relatorioss">Ver Relatórios Salvos</button>
          </form>
      </div>
    </div>
  )
}
