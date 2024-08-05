import React, { useState, useEffect, useContext } from 'react';
import { useNavigate } from 'react-router-dom';
import { handleOnClick } from '../../functions/HandleOnClick';
import '../../styles/pages/Gestao/pedidos.css' // Certifique-se de ter o CSS importado
import { ServiceCtx } from '../../contexts/indusphere/Service';

// Definição do tipo Pedido
interface Pedido {
  id: number;
  tipo: string;
  tamanho: string;
  quantidade: number;
  cor: string;
  tecido: string;
}

export default function Pedidos() {
  const navigate = useNavigate();
  const [pedidos, setPedidos] = useState<Pedido[]>([]);

  // Simulando uma requisição para o back-end
  useEffect(() => {
    // Aqui você faria uma chamada para o back-end para buscar os pedidos
    const fetchPedidos = async () => {
      // Simulando um delay de requisição
      await new Promise((resolve) => setTimeout(resolve, 1000));
      // Substitua com sua lógica de busca de dados
      setPedidos([
        { id: 1, tipo: 'Camisa', tamanho: 'M', quantidade: 2, cor: 'Preto', tecido: 'Algodão' },
        { id: 2, tipo: 'Calça', tamanho: 'G', quantidade: 1, cor: 'Azul', tecido: 'Jeans' },
        { id: 3, tipo: 'Jaqueta', tamanho: 'P', quantidade: 3, cor: 'Verde', tecido: 'Poliéster' },
        // Adicione mais pedidos conforme necessário
      ]);
    };

    fetchPedidos();
  }, []);

  const service = useContext(ServiceCtx)

  useEffect(() => {

      service.setPages([
        {
            label: 'Visualizar pedidos',
            rota: '/gestao/visualizar-pedidos'
        },  
        {
            label: 'Fazer Pedido',
            rota: '/gestao/fazer-pedido'
        },
    ])
    service.setSrcLogo('/logoIndusphere.png')
    
  }, [])


  return (
    <div style={{ width: '100%', height: '100%', display: 'flex', flexDirection: 'column', alignItems: 'center' }}>
      <h1>Pedidos</h1>
      <div className="container">
        <div className="carrossel">
          {pedidos.length > 0 ? (
            pedidos.map((pedido) => (
              <div key={pedido.id} className="pedido">
                <h3>Pedido ID: {pedido.id}</h3>
                <p>Tipo: {pedido.tipo}</p>
                <p>Tamanho: {pedido.tamanho}</p>
                <p>Quantidade: {pedido.quantidade}</p>
                <p>Cor: {pedido.cor}</p>
                <p>Tecido: {pedido.tecido}</p>
              </div>
            ))
          ) : (
            <p>Carregando pedidos...</p>
          )}
        </div>
      </div>
    </div>
  );
}
