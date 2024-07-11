import React from 'react'
import { handleOnClick } from '../../../functions/HandleOnClick'
import { useNavigate } from 'react-router-dom'

export default function ImprimirPecaDetalhes() {
    const navigate = useNavigate()

  return (
    <div class = 'corpo'>
    <div class="manufatura">
        <h1>Imprimir peça</h1>  
    </div>
    <div class="container-peca">
    
            <h1>Engrenagens de avanço de tecido</h1>
            <p for="filamento" >Tipo filamento</p>
            <select id="filamento">

                <option value="" disabled selected>Selecione</option>
                <option value="filamento1">PLA 1,75mm</option>
                <option value="filamento2">Nylon 1,75mm</option>
                <option value="filamento3">ABS 1,75mm</option>
                <option value="filamento4">PLA Ultra Silk 2,80mm</option>
                <option value="filamento5">HIPS 1,75mm</option>
            </select>
            
            <p for="tamanho" id="tamanho" >Tamanho</p>
            <input type="text" id="tamanho" placeholder="Digite o tamanho" />
            <button class="btn imprimir" >Imprimir</button>
            <div class="voltar" id="back-button" onClick={(e) => handleOnClick(e, '/impressora-3d/imprimir-peca', navigate)}>
      <p>Voltar</p>
    </div>
    </div>
    
</div>
  )
}
