package com.example.loginauthapi.service.melato;

import com.example.loginauthapi.domain.user.Erro;
import com.example.loginauthapi.service.ru.ProdutoDTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class ErroDTO {
    private Long id_erro;
    private String descricao_erro;
    private Integer qntd_produto ;
    private String nome_erro;
    private ProdutoDTO produto;

    public ErroDTO(){}

    public ErroDTO(Erro erro){
        BeanUtils.copyProperties(erro, this);
        if (erro != null && erro.getProduto() != null) {
            this.produto = new ProdutoDTO(erro.getProduto());
        }
    }
}
