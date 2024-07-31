package com.example.loginauthapi.service.ru;


import com.example.loginauthapi.domain.user.Usuario;
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
    private Usuario usuarioDTO;
    private RfidDTO rfidDTO;
    private Date dataPedida;
    private Date dataEntrega;
    private Double valorTotal;
    private List<ItenDoPedidoDTO> itensDoPedidoDTO;
    private boolean status;

}
