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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "obs")
    private String obs;

    @OneToOne(cascade = CascadeType.ALL)
    private Cpf cpf;

    @OneToOne(cascade = CascadeType.ALL)
    private Cnpj cnpj;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario user;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
}
