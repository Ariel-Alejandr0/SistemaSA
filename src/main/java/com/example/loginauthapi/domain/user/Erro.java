package com.example.loginauthapi.domain.user;


import com.example.loginauthapi.service.melato.ErroDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Erro")
public class Erro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_erro")
    private Long id_erro;

    @Column(name = "descricao_erro")
    private String descricao_erro;

    @Column(name = "qntd_produto ")
    private Integer qntd_produto ;

    @Column(name = "nome_erro")
    private String nome_erro;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Erro(ErroDTO erro){
        BeanUtils.copyProperties(erro , this);
        if (erro != null && erro.getProduto() != null) {
            this.produto = new Produto(erro.getProduto());
        }
    }


}
