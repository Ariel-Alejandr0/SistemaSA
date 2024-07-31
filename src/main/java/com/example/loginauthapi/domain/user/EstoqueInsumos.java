package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estoque_insumos")
public class EstoqueInsumos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cor")
    private String cor;

    @Column(name = "preco")
    private double preco;

    @Column(name = "uM")
    private String uM;

    @Column(name = "quantidade")
    private double quantidade;

    @Column(name = "tipo")
    private String tipo;

}
