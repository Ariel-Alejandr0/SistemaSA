package com.example.loginauthapi.service.ru;


import com.example.loginauthapi.domain.user.Pedido;
import com.example.loginauthapi.repositories.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private PedidoRepository pedidoRepository;

    Pedido pedido = pedidoRepository.buscarPedidoEmAberto()

}

