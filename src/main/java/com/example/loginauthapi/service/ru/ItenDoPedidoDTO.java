package com.example.loginauthapi.service.ru;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItenDoPedidoDTO {

    private Long id;
    private ProdutoDTO produto;
    private PedidoDTO pedido;
    private double valorUnitario;
    private double valorTotal;


}
