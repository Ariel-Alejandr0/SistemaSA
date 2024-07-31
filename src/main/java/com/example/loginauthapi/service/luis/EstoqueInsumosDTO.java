package com.example.loginauthapi.service.luis;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueInsumosDTO {

    private Long id;
    private String nome;
    private String cor;
    private double preco;
    private String uM;
    private double quantidade;
    private String tipo;
}
