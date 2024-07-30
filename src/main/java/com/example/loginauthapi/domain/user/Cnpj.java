package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CNPJ")
public class Cnpj {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    private Pessoa pessoa;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "I.M")
    private String iM;
    @Column(name = "i.E")
    private String iE;
    @Column(name = "ramo_atividade")
    private String ramoAtividade;

}