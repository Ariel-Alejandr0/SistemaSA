package com.example.loginauthapi.service.geral;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;
    private PessoaDTO pessoa;
    private Instant dataCadastro;
    private String papel;
    private String senha;
    private String email;

    private UsuarioDTO(PessoaDTO pessoa, Instant dataCadastro, String papel, String sennha, String email) {
        this.pessoa = pessoa;
        this.dataCadastro = dataCadastro;
        this.papel = papel;
        this.email = email;
        this.senha = senha;
    }
}
