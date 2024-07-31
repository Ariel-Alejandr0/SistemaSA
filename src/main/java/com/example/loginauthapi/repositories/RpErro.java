package com.example.loginauthapi.repositories;


import com.example.loginauthapi.domain.user.Erro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RpErro extends JpaRepository<Erro,Long> {
}
