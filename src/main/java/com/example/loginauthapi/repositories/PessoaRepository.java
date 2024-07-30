package com.example.loginauthapi.repositories;


import com.example.loginauthapi.domain.user.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
