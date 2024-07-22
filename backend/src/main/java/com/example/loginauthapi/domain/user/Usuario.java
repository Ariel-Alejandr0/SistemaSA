package com.example.loginauthapi.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Table(name = "Usuario")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id_usuario")
@JsonIgnoreProperties("machines") // Ignora a serialização da lista de machines
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
    private Instant dataCadastro;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Machine> machines;

    public Usuario(String nome, String email, String idPapel, String senha, Long idPessoa, Instant dataCadastro) {
        this.nome = nome;
        this.email = email;
        this.idPapel = idPapel;
        this.senha = senha;
        this.idPessoa = idPessoa;
        this.dataCadastro = Instant.now();
    }
}
