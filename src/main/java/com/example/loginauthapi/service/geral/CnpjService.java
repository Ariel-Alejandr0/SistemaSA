package com.example.loginauthapi.service.geral;


import com.example.loginauthapi.domain.user.Cnpj;
import com.example.loginauthapi.repositories.CnpjRepository;
import com.example.loginauthapi.repositories.EnderecoRepository;
import com.example.loginauthapi.repositories.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CnpjService {

    CnpjRepository repository;
    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;


    public void post(Cnpj cnpjDTO){

    }
}
