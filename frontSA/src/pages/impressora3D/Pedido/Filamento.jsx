import React from 'react'
import { handleOnClick } from '../../../functions/HandleOnClick'
import { useNavigate } from 'react-router-dom'

export default function Filamento() {
    const navigate = useNavigate()
  return (
    <div class = 'corpo'>
    <div class="manufatura" >
    <h1>Pedir Filamento ao Fornecedor</h1>
    </div>
    <div class="container-fornecedor">
        <form>
            <label for="tipo-peca">Tipo Filamento</label>
            <select id="tipo-peca" name="tipo-peca">
                <option value="" disabled selected>Selecione o tipo de Filamento</option>
                <option value="filamento1">PLA 1,75mm</option>
                <option value="filamento2">Nylon 1,75mm</option>
                <option value="filamento3">ABS 1,75mm</option>
                <option value="filamento4">PLA Ultra Silk 2,80mm</option>
                <option value="filamento5">HIPS 1,75mm</option>
            </select>
            <label for="quantidade">Quantidade</label>
            <input type="number" id="quantidade" name="quantidade" min="1" placeholder="Digite a quantidade"/>
            <button type="submit" class="btn">Fazer pedido</button>
        </form>
        <div class="voltar" id="back-button" onClick={(e) => handleOnClick(e, '/impressora-3d/fazer-pedido', navigate)}>
      <p>Voltar</p>
    </div>
    </div>
</div>
  )
}