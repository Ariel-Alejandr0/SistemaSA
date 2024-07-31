package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "pessoaJuridica")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaJuridica {

    @Id
    @OneToOne
    private Pessoa pessoa;

    private String cnpj;
    private String nomeFantasia;
    private String tipo;
    private String ie;
    private String im;
    private String ramoAtividade;
}
