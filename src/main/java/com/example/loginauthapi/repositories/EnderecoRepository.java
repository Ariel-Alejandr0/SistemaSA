package com.example.loginauthapi.repositories;


import com.example.loginauthapi.domain.user.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco,Long> {
}
