package com.example.loginauthapi.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private RFID rfid;

    @OneToOne
    private Usuario usuario;

    @Column(name = "data_pedida")
    private Date dataPedida;

    @Column(name = "data_entrega")
    private Date dataEntrega;

    @Column(name = "valor_total")
    private Double valorTotal;

    @OneToMany
    private List<ItenDoPedido> itensDoPedido;

    @Column(name = "status")
    private Boolean status;

    public void adicionarItemPedido(ItenDoPedido item){
        
        valorTotal = 0.0;
        for(ItenDoPedido i : itensDoPedido){
            valorTotal += i.getValorTotal();
        }
    }
}
