package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;


@Table(name = "users")
@Entity(name = "users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_usuario")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;
    private String name;
    private String email;
    private String AcessCode;
    private String password;
    private Long idPessoa;
    private Date dataCadastro;
    private int idPapel;


    @OneToOne
    private Pessoa pessoa;


    public User(String name, String email, String AcessCode, String password, Long idPessoa, Date dataCadastro, int idPapel) {
        this.name = name;
        this.email = email;
        this.AcessCode = AcessCode;
        this.password = password;
        this.idPessoa = idPessoa;
        this.dataCadastro = dataCadastro;
        this.idPapel = idPapel;

    }
}