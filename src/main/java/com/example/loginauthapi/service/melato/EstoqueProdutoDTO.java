package com.example.loginauthapi.service.melato;

import com.example.loginauthapi.domain.user.Estoque_Produto;
import com.example.loginauthapi.service.ru.ProdutoDTO;;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class EstoqueProdutoDTO {
    private Long Id_estoque;
    private Integer qtdproduto;
    private ProdutoDTO produto;

public EstoqueProdutoDTO() {}

    public EstoqueProdutoDTO(Estoque_Produto estoque) {
        BeanUtils.copyProperties(estoque, this);
        if (estoque != null && estoque.getProduto() != null) {
            this.produto = new ProdutoDTO(estoque.getProduto());
        }
    }
}
