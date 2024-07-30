package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder; // Adicione esta importação
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idPessoa")
@Builder // Adicione esta anotação
public class Pessoa {

    @OneToOne(mappedBy = "pessoa",cascade = CascadeType.ALL)
    private PessoaFisica pessoaFisica;

    @OneToOne(mappedBy = "pessoa",cascade = CascadeType.ALL)
    private PessoaJuridica pessoaJuridica;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private Usuario user;

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
