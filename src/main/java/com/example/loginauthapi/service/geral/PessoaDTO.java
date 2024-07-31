package com.example.loginauthapi.service.geral;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDTO {

    private Long id;
    private String nome;
    private String tipo;
    private String telefone;
    private String obs;
    private EnderecoDTO endereco;

    private PessoaDTO(String nome, String tipo, String telefone, String obs,EnderecoDTO endereco) {
        this.nome = nome;
        this.tipo = tipo;
        this.telefone = telefone;
        this.obs = obs;
        this.endereco = endereco;
    }

}
