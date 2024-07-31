package com.example.loginauthapi.domain.user;

import com.example.loginauthapi.service.melato.QualidadeDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;


@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Qualidade")
public class Qualidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Qualidade")
    private Long id_Qualidade;

    @Column(name = "data_enviada")
    private String data_enviada;

    @Column(name = "data_retorno")
    private String data_retorno;

    @Column(name = "qtd_enviada")
    private Integer qtd_enviada;

    @Column(name = "qtd_retorno")
    private Integer qtd_retorno;

   @ManyToOne
   @JoinColumn(name = "id_produto")
   private Produto produto;

   @ManyToOne
   @JoinColumn(name = "id_erro")
   private Erro erro;

   public Qualidade(QualidadeDTO qualidadeDTO){
        BeanUtils.copyProperties(qualidadeDTO, this);
        if (qualidadeDTO != null && qualidadeDTO.getProduto() != null) {
            this.produto = new Produto(qualidadeDTO.getProduto());
        }

        if (qualidadeDTO != null && qualidadeDTO.getErro() != null) {
            this.erro = new Erro(qualidadeDTO.getErro());
        }
    }


}
