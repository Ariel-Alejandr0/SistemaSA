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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private Pessoa pessoa;

    @Column(name = "cnpj")
    private String cnpj;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "iE")
    private String ie;

    @Column(name = "iM")
    private String im;

    @Column(name = "ramo_atividade")
    private String ramoAtividade;
}
