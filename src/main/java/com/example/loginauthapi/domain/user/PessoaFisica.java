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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private Pessoa pessoa;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Column(name = "genero")
    private String genero;

}
