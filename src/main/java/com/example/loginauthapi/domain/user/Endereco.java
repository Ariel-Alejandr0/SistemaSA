package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "endereco")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "endereco")
public class Endereco {

    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEndereco")
    private Long idEndereco;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "numero")
    private String numero;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "CEP")
    private String cep;
}
