package com.example.loginauthapi.service.geral;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CnpjDTO extends PessoaDTO {

    private Long id;
    private String cnpj;
    private String nomeFantasia;
    private String tipo;
    private String iM;
    private String iE;
    private String ramoAtividade;

}
