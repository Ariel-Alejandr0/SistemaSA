package com.example.loginauthapi.service.ru;

import com.example.loginauthapi.domain.user.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Usuario usuarioDTO;
    private Long id;
    private String material;
    private String cor;
    private Tamanho tamanho;
    private Tipo tipo;
    private int quantidade;

}
