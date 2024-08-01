package com.example.loginauthapi.repositories;


import com.example.loginauthapi.domain.user.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findAll();

    @Query("SELECT p FROM Pedido p WHERE p.status = :status")
    Pedido buscarPedidoEmAberto(@Param("status") boolean status);
}
