package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idPessoa")
public class Pessoa {


    @OneToOne(mappedBy = "pessoa",cascade = CascadeType.ALL)
    private PessoaFisica pessoaFisica;

    @OneToOne(mappedBy = "pessoa",cascade = CascadeType.ALL)
    private PessoaJuridica pessoaJuridica;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Fornecedor fornecedor;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private User user;

    @OneToOne
    private Endereco endereco;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPessoa")
    private Long idPessoa;

    private String nome;
    private String tipo;
    private String telefone;
    private String obs;
}