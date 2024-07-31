package com.example.loginauthapi.repositories;


import com.example.loginauthapi.domain.user.Cnpj;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CnpjRepository extends JpaRepository<Cnpj, Long> {
}
