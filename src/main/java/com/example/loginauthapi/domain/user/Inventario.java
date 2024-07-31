package com.example.loginauthapi.domain.user;


import com.example.loginauthapi.service.frank.LocalITem;
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
@Table(name = "invetario")
public class Inventario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inventario")
    private Long id;

    @Column(name = "item")
    private String item;

    @Column(name = "valor_item")
    private Integer valorItem;

    @Column(name = "categoriaItem")
    private Integer categoriaItem;

    @Column(name = "local_item")
    private LocalITem localItem;
}