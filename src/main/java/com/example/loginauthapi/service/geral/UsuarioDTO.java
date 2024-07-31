package com.example.loginauthapi.service.geral;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO extends PessoaDTO {

    private Long id;
    private PessoaDTO pessoa;
    private Date dataCadastro;
    private int papel;
    private String senha;
    private String email;

    private UsuarioDTO(PessoaDTO pessoa, Date dataCadastro, int papel, String sennha, String email) {
        this.pessoa = pessoa;
        this.dataCadastro = dataCadastro;
        this.papel = papel;
        this.email = email;
        this.senha = senha;
    }
}
