package com.example.loginauthapi.controllers;


import com.example.loginauthapi.service.geral.CpfDTO;
import com.example.loginauthapi.service.geral.CpfService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cpf")
@AllArgsConstructor
public class CpfController {

    private final CpfService cpfService;

    @PostMapping
    public ResponseEntity<String> adicionarCpf(@RequestBody CpfDTO cpfDTO){
        cpfService.inserir(cpfDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("CPF adicionado com sucesso");
    }
}
