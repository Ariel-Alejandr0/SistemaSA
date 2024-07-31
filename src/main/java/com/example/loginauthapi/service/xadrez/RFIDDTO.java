package com.example.loginauthapi.service.xadrez;

import com.example.loginauthapi.domain.user.Localizacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RFIDDTO {

    private Long id_RFID;
    private Localizacao id_localizacao;
    private Date data_ativacao;
    private Date data_atualizacao;
    private String tag_leitura;

    private RFIDDTO(Localizacao id_localizacao, Date data_ativacao, Date data_atualizacao, String tag_leitura) {
        this.id_localizacao = id_localizacao;
        this.data_ativacao = data_ativacao;
        this.data_atualizacao = data_atualizacao;
        this.tag_leitura = tag_leitura;
    }
}
