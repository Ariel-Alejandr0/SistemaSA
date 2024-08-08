package demo.sa304.DTO;

import demo.sa304.Entity.Estoque_Produto;
import demo.sa304.Entity.Produto;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class EstoqueDTO {
    private Long Id_estoque;
    private Integer qtdproduto;
    private ProdutoDTO produto;

public EstoqueDTO() {}

    public  EstoqueDTO(Estoque_Produto estoque) {
        BeanUtils.copyProperties(estoque, this);
        if (estoque != null && estoque.getProduto() != null) {
            this.produto = new ProdutoDTO(estoque.getProduto());
        }

    }
}
