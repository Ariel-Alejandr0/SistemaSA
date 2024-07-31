package com.example.loginauthapi.dto;


import com.example.loginauthapi.domain.user.Pessoa;

import java.time.Instant;
import java.util.Date;

public record RegisterRequestDTO(String nome, String email, String idPapel, String senha, Pessoa pessoa, Instant dataCadastro) {

}
