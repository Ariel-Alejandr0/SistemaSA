package demo.sa304.Entity;

import demo.sa304.DTO.EstoqueDTO;
import demo.sa304.DTO.ProdutoDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Estoque_Produto")
@EqualsAndHashCode(of = "Id_estoque_produto")
public class Estoque_Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_estoque")
    private Long Id_estoque;
    @Column(name = "qtdproduto")
    private Integer qtdproduto;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Estoque_Produto(EstoqueDTO estoque ){
        BeanUtils.copyProperties(estoque , this);
        if (estoque != null && estoque.getProduto() != null) {
            this.produto = new Produto(estoque.getProduto());
        }
    }



}
