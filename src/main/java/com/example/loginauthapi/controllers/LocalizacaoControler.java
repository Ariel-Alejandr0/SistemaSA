package com.example.loginauthapi.controllers;

import com.example.loginauthapi.domain.user.Localizacao;
import com.example.loginauthapi.service.xadrez.LocalizacaoDTO;
import com.example.loginauthapi.service.xadrez.LocalizacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/localizacao")
public class LocalizacaoControler {

    private final LocalizacaoService localizacaoService;

    @Autowired
    public LocalizacaoControler(LocalizacaoService localizacaoService) {
        this.localizacaoService = localizacaoService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> criarLocalizacao(@RequestBody LocalizacaoDTO localizacaoDTO) {
        localizacaoService.criarLocalizacao(localizacaoDTO);
        return new ResponseEntity<>("Localizacao created successfully", HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateLocalizacao(@RequestBody LocalizacaoDTO localizacaoDTO) {
        try {
            localizacaoService.updateLocalizacao(localizacaoDTO);
            return new ResponseEntity<>("Localizacao updated successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Localizacao> getLocalizacaoById(@PathVariable Long id) {
        try {
            Localizacao localizacao = localizacaoService.findById(id);
            return new ResponseEntity<>(localizacao, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Localizacao>> getAllLocalizacoes() {
        List<Localizacao> localizacoes = localizacaoService.findAll();
        return new ResponseEntity<>(localizacoes, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLocalizacao(@PathVariable Long id) {
        try {
            localizacaoService.deleteById(id);
            return new ResponseEntity<>("Localizacao deleted successfully", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
