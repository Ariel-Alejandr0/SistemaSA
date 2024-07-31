package demo.sa304.DTO;

import com.fasterxml.jackson.databind.util.BeanUtil;
import demo.sa304.Entity.Produto;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class ProdutoDTO {
    private Long id_produto;
    private String nome;
    private String descricao;
    private String tamanho;
    private String status_produto;
    private String cor;

   public ProdutoDTO() {}


    public ProdutoDTO(Produto produto) {
        BeanUtils.copyProperties(produto, this);
    }
}
