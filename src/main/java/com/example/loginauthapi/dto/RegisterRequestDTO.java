package com.example.loginauthapi.dto;

import java.util.Date;

public record RegisterRequestDTO(String name, String email, String AcessCode, String password, Long idPessoa, Date dataCadastro, int idPapel) {

}
