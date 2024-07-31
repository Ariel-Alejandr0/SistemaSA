package com.example.loginauthapi.domain.user;


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
@Table(name = "pedido")
public class ItenDoPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private Produto produto;

    @OneToOne
    private Pedido pedido;

    @Column(name = "valor_unitario")
    private double valorUnitario;

    @Column(name = "valor_total")
    private double valorTotal;


    public ItenDoPedido(Produto produto, Tipo tipo, EstoqueInsumos estoqueInsumos, ItenDoPedido itenDoPedido){
        this.produto = produto;
        this.valorUnitario = produto.calcularValorUnitario(tipo,estoqueInsumos);
        this.valorTotal = produto.calcularValorTotal(itenDoPedido,estoqueInsumos);
    }
}
