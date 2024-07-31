package com.example.loginauthapi.repositories;


import com.example.loginauthapi.domain.user.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findAll();
//    List<Pedido> findAllByUsuario_IdUsuario(Long idUsuario);
}
