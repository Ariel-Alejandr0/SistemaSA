import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { handleOnClick } from '../../functions/HandleOnClick';
import '../../styles/pages/Gestao/fazerpedido.css';

export default function FazerPedidos() {
  const navigate = useNavigate();
  const [pedido, setPedido] = useState({
    tipo: '',
    tamanho: '',
    quantidade: 0,
    cor: '',
    tecido: '',
  });

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLSelectElement>) => {
    setPedido({ ...pedido, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    // Aqui você pode enviar os dados do pedido para o back-end ou processá-los conforme necessário.
    console.log(pedido);
  };

  return (
    <div style={{ width: '100%', height: '100%', display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
      <h1>Fazer Pedido</h1>
      <div className="container">
        <div className="buttons">
        </div>
        <form className="pedido-form" onSubmit={handleSubmit}>
          <label>Tipo:</label>
          <select name="tipo" value={pedido.tipo} onChange={handleChange} required>
            <option value="">Selecione</option>
            <option value="Camisa">Camisa</option>
            <option value="Calça">Calça</option>
            <option value="Jaqueta">Jaqueta</option>
          </select>

          <label>Tamanho:</label>
          <select name="tamanho" value={pedido.tamanho} onChange={handleChange} required>
            <option value="">Selecione</option>
            <option value="P">P</option>
            <option value="M">M</option>
            <option value="G">G</option>
            <option value="GG">GG</option>
          </select>

          <label>Quantidade:</label>
          <input type="number" name="quantidade" value={pedido.quantidade} onChange={handleChange} required />

          <label>Cor:</label>
          <select name="cor" value={pedido.cor} onChange={handleChange} required>
            <option value="">Selecione</option>
            <option value="Preto">Preto</option>
            <option value="Branco">Branco</option>
            <option value="Azul">Azul</option>
            <option value="Verde">Verde</option>
          </select>

          <label>Tecido:</label>
          <select name="tecido" value={pedido.tecido} onChange={handleChange} required>
            <option value="">Selecione</option>
            <option value="Algodão">Algodão</option>
            <option value="Jeans">Jeans</option>
            <option value="Poliéster">Poliéster</option>
          </select>

          <button type="submit">Enviar Pedido</button>
        </form>
      </div>
    </div>
  );
}
