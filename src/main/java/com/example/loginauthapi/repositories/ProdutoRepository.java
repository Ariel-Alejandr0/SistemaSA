package com.example.loginauthapi.repositories;


import com.example.loginauthapi.domain.user.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
