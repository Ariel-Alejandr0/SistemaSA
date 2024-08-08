package demo.sa304.DTO;

import demo.sa304.Entity.Erro;
import demo.sa304.Entity.Produto;
import demo.sa304.Entity.Qualidade;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

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
