package com.example.loginauthapi.service.processo_prod;


import com.example.loginauthapi.domain.user.Pedido;
import com.example.loginauthapi.repositories.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private PedidoRepository repository;

}
