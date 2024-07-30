package demo.sa304.Entity;


import demo.sa304.DTO.ProdutoDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Produto")
@EqualsAndHashCode(of = "id_produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id_produto;
    @Column(name = "nome" )
    private String nome;
    @Column(name = "descricao" )
    private String descricao;
    @Column(name = "tamanho" )
    private String tamanho;
    @Column(name = "status_produto")
    private String status_produto;
    @Column(name = "cor")
    private String cor;






    public  Produto(ProdutoDTO produtoDTO) {
        BeanUtils.copyProperties(produtoDTO, this);
    }


}
