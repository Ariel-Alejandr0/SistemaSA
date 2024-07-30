package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CPF")
public class Cpf {

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
    private Character genero;
}
