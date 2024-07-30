package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idEndereco")
public class Endereco {



    @OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEndereco")
    private Long idEndereco;

    private String logradouro;
    private String bairro;
    private String numero;
    private String cidade;
    private String estado;
    private String complemento;
    private String cep;


}
