package com.example.loginauthapi.controllers;

import com.example.loginauthapi.domain.user.User;
import com.example.loginauthapi.dto.RegisterRequestDTO;
import com.example.loginauthapi.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    // Construtor para injeção de dependência
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Endpoint para obter informações do usuário
    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("sucesso!");
    }

    // Endpoint para registrar um novo usuário
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequestDTO userData) {
        // Cria um novo usuário a partir dos dados fornecidos
        User newUser = new User(userData.name(), userData.email(), userData.idPapel(), userData.password());
        userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }

}
