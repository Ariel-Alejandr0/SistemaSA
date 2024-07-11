import React from 'react'

export default function GerarRelatorio() {
  return (
    <div style={{width: '100%', height: '100%', display: 'flex', justifyContent: 'center', alignItems: 'center'}} >
        <div className="container">
            <h1>Gerar Relatório</h1>
            <form id="formRelatorio">
                <label >Formato do Relatório:</label>
                <select id="formatoRelatorio" name="formatoRelatorio" required>
                    <option value="impressao">Impressão</option>
                    <option value="pdf">PDF</option>
                </select>
                <button type="submit">Gerar</button>
            </form>
        </div>
    </div>
  )
}
