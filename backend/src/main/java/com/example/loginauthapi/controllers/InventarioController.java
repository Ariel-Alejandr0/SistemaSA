package com.example.loginauthapi.controllers;


import com.example.loginauthapi.domain.user.Inventario;
import com.example.loginauthapi.service.frank.InventarioDTO;
import com.example.loginauthapi.service.frank.InventarioService;
import com.example.loginauthapi.service.frank.LocalITem;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventario")
@AllArgsConstructor
public class InventarioController {

    private InventarioService service;

    @PostMapping("/add")
    public ResponseEntity<String> adicionarIntens(@RequestBody InventarioDTO inventarioDTO) {
        service.adicionarItens(inventarioDTO);
        return ResponseEntity.status(201).body("Item adicionado com sucesso");
    }

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Inventario>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @DeleteMapping("/excluir")
    public ResponseEntity<String> excluirItem(@PathVariable Long id) {
        service.excluirItem(id);
        return ResponseEntity.status(200).body("Item excluído com sucesso");
    }

    @PatchMapping("/lugar/alterar")
    public ResponseEntity<String> alterarItemDeLugar(@PathVariable Long id, @RequestBody LocalITem novoLocal) {
        service.alterarItemdeLugar(id, novoLocal);
        return ResponseEntity.status(200).body("Item alterado com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inventario> buscarItemPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarItemPorId(id));
    }
}
