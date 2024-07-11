import React from 'react'

export default function ListarErros() {
  return (
    <div style={{width: '100%', height: '100%', display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
        <div  class="container">
            <h1>Listar Erros</h1>
            <form id="formListaErros">
                <div id="errosContainer"></div>
                <button type="button" id="adicionarErro">Adicionar Erro</button>
                <button type="submit">Próximo</button>
            </form>
        </div>
        <script src="scripts.js"></script>
    </div>
  )
}
