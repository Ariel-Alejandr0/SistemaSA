package com.example.loginauthapi.repositories;


import com.example.loginauthapi.domain.user.Inventario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventarioRepository extends JpaRepository<Inventario,Long> {
}
