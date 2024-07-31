package com.example.loginauthapi.repositories;

import com.example.loginauthapi.domain.user.Usuario;
import com.example.loginauthapi.domain.user.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Interface de repositório para a entidade User, utilizando JPA
public interface UserRepository extends JpaRepository<Usuario, Long> {
    // Método para buscar um usuário pelo email
    Optional<Usuario> findByEmail(String email);
}
