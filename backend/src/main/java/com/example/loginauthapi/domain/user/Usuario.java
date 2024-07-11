package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "Usuario")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;

    private String nome;
    private String email;
    private String idPapel;
    private String senha;
    private Long idPessoa;
    private Date dataCadastro;


    public Usuario(String nome, String email, String idPapel, String senha, Long idPessoa, Date dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.idPapel = idPapel;
        this.senha = senha;
        this.idPessoa = idPessoa;
        this.dataCadastro = dataCadastro;

    }


}


