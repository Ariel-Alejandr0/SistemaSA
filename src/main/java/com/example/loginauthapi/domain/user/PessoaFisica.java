package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity(name = "pessoaFisica")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaFisica {

    @Id
    @OneToOne
    private Pessoa pessoa;

    private String cpf;
    private Date dataNascimento;
    private String genero;
}
