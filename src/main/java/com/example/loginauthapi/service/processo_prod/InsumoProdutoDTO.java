package com.example.loginauthapi.service.processo_prod;


import com.example.loginauthapi.service.cadeia_sup.EstoqueInsumosDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InsumoProdutoDTO {

    private Long id;
    private ProdutoDTO produto;
    private EstoqueInsumosDTO estoqueInsumos;
    private double quantidadeInsumo;


}
