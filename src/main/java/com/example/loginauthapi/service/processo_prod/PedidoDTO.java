package com.example.loginauthapi.service.processo_prod;


import com.example.loginauthapi.service.geral.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {

    private Long id;
    private UsuarioDTO usuarioDTO;
    private RfidDTO rfidDTO;
    private Date dataPedida;
    private Date dataEntrega;
    private Double valorTotal;
    private List<ItenDoPedidoDTO> itensDoPedidoDTO;
    private boolean status;

}
