package com.example.loginauthapi.service.ru;


import com.example.loginauthapi.domain.user.Pedido;
import com.example.loginauthapi.repositories.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private PedidoRepository repository;

//    public List<Pedido> listarPedidosPorUsuarioId(Long id_usuario) {
//        return repository.findAllByUsuario_IdUsuario(id_usuario);
//    }
}
