package com.example.loginauthapi.dto;

import com.example.loginauthapi.domain.user.Pessoa;

public record ResponseDTO (String nome, String idPapel, String token, Long id_usuario, Pessoa pessoa) { }
