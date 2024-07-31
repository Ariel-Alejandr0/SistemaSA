package com.example.loginauthapi.service.melato;

import com.example.loginauthapi.domain.user.Qualidade;
import com.example.loginauthapi.service.ru.ProdutoDTO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class QualidadeDTO {
    private Long id_Qualidade;
    private String data_enviada;
    private String data_retorno;
    private Integer qtd_enviada;
    private Integer qtd_retorno;
    private ProdutoDTO produto;
    private ErroDTO erro;

    public QualidadeDTO() {}

    public QualidadeDTO(Qualidade qualidade) {
        BeanUtils.copyProperties(qualidade, this);
        if (qualidade != null && qualidade.getProduto() != null) {
            this.produto = new ProdutoDTO(qualidade.getProduto());
        }

        if (qualidade != null && qualidade.getErro() != null) {
            this.erro = new ErroDTO(qualidade.getErro());
        }
    }
}
