package com.example.loginauthapi.service.processo_prod;

import com.example.loginauthapi.service.geral.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private UsuarioDTO usuarioDTO;
    private Long id;
    private String material;
    private String cor;
    private Tamanho tamanho;
    private Tipo tipo;
    private int quantidade;

}
