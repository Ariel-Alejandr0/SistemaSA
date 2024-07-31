package com.example.loginauthapi.controllers;


import com.example.loginauthapi.domain.user.EstoqueInsumos;
import com.example.loginauthapi.service.luis.EstoqueInsumosDTO;
import com.example.loginauthapi.service.luis.EstoqueInsumosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque/insumos")
@AllArgsConstructor
public class EstoqueInsumosController {

    private final EstoqueInsumosService estoqueInsumosService;

    @PostMapping("/adicionar")
    public ResponseEntity<String> adicionarInsumos(@RequestBody EstoqueInsumosDTO estoqueInsumosDTO) {
        estoqueInsumosService.adicionarInsumos(estoqueInsumosDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Insumo adicionado com sucesso");
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<String> atualizarInsumos(@PathVariable Long id, @RequestBody EstoqueInsumosDTO estoqueInsumosDTO) {
        estoqueInsumosDTO.setId(id); // Define o ID no DTO para garantir que o ID seja passado corretamente
        estoqueInsumosService.updateEstoqueInsumos(estoqueInsumosDTO);
        return ResponseEntity.ok("Insumo atualizado com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstoqueInsumos> buscarInsumoPorId(@PathVariable Long id) {
        EstoqueInsumos insumo = estoqueInsumosService.findById(id);
        return ResponseEntity.ok(insumo);
    }

}
