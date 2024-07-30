package com.example.loginauthapi.repositories;


import com.example.loginauthapi.domain.user.Cpf;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CpfRepository extends JpaRepository<Cpf,Long> {
}
