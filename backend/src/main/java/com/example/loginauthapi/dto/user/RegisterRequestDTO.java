package com.example.loginauthapi.dto.user;


import java.util.Date;

public record RegisterRequestDTO(String nome, String email, String idPapel, String senha, Long idPessoa, Date dataCadastro) {

}