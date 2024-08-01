package com.example.loginauthapi.service.ru;


import com.example.loginauthapi.domain.user.ItenDoPedido;
import com.example.loginauthapi.domain.user.Pedido;
import com.example.loginauthapi.repositories.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public void adicionarItemPedido(ItenDoPedidoDTO item) {
        Pedido pedido = pedidoRepository.buscarPedidoEmAberto(true);

        if (pedido == null) {
            pedido.adicionarItemPedido(new ItenDoPedido());
        } else {
            pedido = new Pedido();
            pedido.adicionarItemPedido(new ItenDoPedido());
        }
        pedidoRepository.save(pedido);
    }
}

