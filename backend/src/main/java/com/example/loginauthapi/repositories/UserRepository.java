package com.example.loginauthapi.repositories;

import com.example.loginauthapi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Interface de repositório para a entidade User, utilizando JPA
public interface UserRepository extends JpaRepository<User, String> {
    // Método para buscar um usuário pelo email
    Optional<User> findByEmail(String email);
}
