package com.example.loginauthapi.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;


@Entity(name = "Usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties("machines") // Ignora a serialização da lista de machines
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "id_papel")
    private String idPapel;

    @Column(name = "senha")
    private String senha;

    @OneToOne
    private Pessoa pessoa;

    @Column(name = "data_cadastro")
    private Instant dataCadastro;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Machine> machines;

    public Usuario(String nome, String email, String idPapel, String senha, Pessoa pessoa, Instant dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.idPapel = idPapel;
        this.senha = senha;
        this.pessoa = pessoa;
        this.dataCadastro = Instant.now();
    }
}
