package com.example.loginauthapi.controllers;


import com.example.loginauthapi.domain.user.EstoquePecas;
import com.example.loginauthapi.service.rampeloti.EstoquePecasDTO;
import com.example.loginauthapi.service.rampeloti.EstoquepecasService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pecas")
@AllArgsConstructor
public class EstoquePecasController {

    private final EstoquepecasService service;

    @PostMapping("/add")
    public ResponseEntity<String> addPecas(@RequestBody EstoquePecasDTO estoquePecasDTO) {
        service.addPecas(estoquePecasDTO);
        return ResponseEntity.status(201).body("Peças adicionadas ao estoque com sucesso");
    }

    @PatchMapping("/preco")
    public ResponseEntity<String> alterarPreco(@RequestBody EstoquePecasDTO estoquePecasDTO) {
        service.alterarPreco(estoquePecasDTO);
        return ResponseEntity.status(200).body("Preço das peças alterado com sucesso");
    }

    @GetMapping("/listarPecas")
    public ResponseEntity<Iterable<EstoquePecas>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
    @PatchMapping("/quantidade")
    public ResponseEntity<String> alterarQuantidade(@RequestBody EstoquePecasDTO estoquePecasDTO) {
        service.alterarQuantidade(estoquePecasDTO);
        return ResponseEntity.status(200).body("Quantidade das peças alterada com sucesso");
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> excluirPeca(@PathVariable Long id) {
        service.excluirItem(id);
        return ResponseEntity.status(200).body("Peça excluída com sucesso");
    }
}
