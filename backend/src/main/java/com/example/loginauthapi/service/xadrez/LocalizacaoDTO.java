package com.example.loginauthapi.service.xadrez;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalizacaoDTO {

    private Long id_localizacao;
    private String enderacamento;

    public LocalizacaoDTO(String enderacamento) {
        this.enderacamento = enderacamento;
    }
}
