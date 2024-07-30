package com.example.loginauthapi.domain.user;


import com.example.loginauthapi.service.ru.Tamanho;
import com.example.loginauthapi.service.ru.Tipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "material")
    private String material;
    @Column(name = "cor")
    private String cor;
    @Column(name = "tamanho")
    private Tamanho tamanho;
    @Column(name = "tipo")
    private Tipo tipo;
    @ManyToOne(targetEntity = Produto.class)
    private Usuario usuario;
    @Column(name = "quantidade")
    private int quantidade;

    public double calcularValorUnitario(Tipo tipo,EstoqueInsumos estoqueInsumos ) {
        return (tipo.getCentimetros() * estoqueInsumos.getPreco()) * 1.10;
    }

    public double calcularValorTotal(ItenDoPedido it,EstoqueInsumos estoqueInsumos) {
        return calcularValorUnitario(tipo, estoqueInsumos) * it.getProduto().getQuantidade();
    }

}
