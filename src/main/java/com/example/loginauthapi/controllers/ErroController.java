package com.example.loginauthapi.controllers;

import com.example.loginauthapi.service.melato.ErroDTO;
import com.example.loginauthapi.service.melato.ErroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/erro/")
public class ErroController {

    @Autowired
    private ErroService erroService;

    @GetMapping("/listar")
    public List<ErroDTO> getAllErro(){
        return erroService.listar();
    }

    @PostMapping("/add")
    public void incluir(@RequestBody ErroDTO erroDTO) {
        erroService.incluir(erroDTO);
    }

    @PutMapping("/alterar")
    public ErroDTO alterar(@RequestBody ErroDTO erroDTO) {
        return erroService.alterar(erroDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id ) {
        erroService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
