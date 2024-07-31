package com.example.loginauthapi.service.geral;

import lombok.*;
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
