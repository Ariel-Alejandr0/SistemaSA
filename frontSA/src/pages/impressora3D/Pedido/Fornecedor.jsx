import React from 'react'
import { handleOnClick } from '../../../functions/HandleOnClick'
import { useNavigate } from 'react-router-dom'

export default function Fornecedor() {
    const navigate = useNavigate()
  return (
    <div class = 'corpo'>
    <div class="manufatura" >
    <h1>Pedir Peças ao Fornecedor</h1>
    </div>
    <div class="container-fornecedor">
        <form>
            <label for="tipo-peca">Tipo peça</label>
            <select id="tipo-peca" name="tipo-peca">
                <option value="" disabled selected>Selecione o tipo de peça</option>
                <option value="peca1">Engrenagem de câmbio</option>
                <option value="peca2">Engrenagem de rotação do pente</option>
                <option value="peca3">Engrenagens de avanço de tecido</option>
                <option value="peca3">Engrenagem Reta Módulo</option>
                <option value="peca3">Engrenagem planetária</option>
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
