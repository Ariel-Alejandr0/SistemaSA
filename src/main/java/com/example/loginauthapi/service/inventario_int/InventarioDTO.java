package com.example.loginauthapi.service.inventario_int;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventarioDTO {

    private Long id;
    private String item;
    private Integer valorItem;
    private Integer categoriaItem;
    private LocalITem localItem;
}
