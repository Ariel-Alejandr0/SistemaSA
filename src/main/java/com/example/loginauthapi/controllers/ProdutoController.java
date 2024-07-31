package com.example.loginauthapi.controllers;


import com.example.loginauthapi.service.ru.ProdutoDTO;
import com.example.loginauthapi.service.ru.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
@AllArgsConstructor
public class ProdutoController {

    private ProdutoService produtoService;

    @PostMapping("/criar")
    public ResponseEntity<String> criarProduto(@RequestBody ProdutoDTO produtoDTO) {
        produtoService.criarProduto(produtoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("produto criado com sucesso");
    }

}
