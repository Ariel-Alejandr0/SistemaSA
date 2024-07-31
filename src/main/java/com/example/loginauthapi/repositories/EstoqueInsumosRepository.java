package com.example.loginauthapi.repositories;


import com.example.loginauthapi.domain.user.EstoqueInsumos;
import com.example.loginauthapi.service.luis.EstoqueInsumosDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EstoqueInsumosRepository extends JpaRepository<EstoqueInsumos,Long> {
    Optional<EstoqueInsumosDTO> findByNomeAndCorAndTipo(String nome, String cor, String tipo);
    List<EstoqueInsumos> findByNomeAndCor(String nome, String cor);
}
