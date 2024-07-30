package com.example.loginauthapi.service.geral;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CpfDTO extends PessoaDTO {

    private Long id;
    private String cpf;
    private Date dataNascimento;
    private Character genero;

}
