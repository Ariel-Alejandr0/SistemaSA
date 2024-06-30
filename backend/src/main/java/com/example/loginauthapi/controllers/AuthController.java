package com.example.loginauthapi.controllers;

import com.example.loginauthapi.domain.user.User;
import com.example.loginauthapi.dto.LoginRequestDTO;
import com.example.loginauthapi.dto.RegisterRequestDTO;
import com.example.loginauthapi.dto.ResponseDTO;
import com.example.loginauthapi.infra.security.TokenService;
import com.example.loginauthapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    // Injeta automaticamente as dependências necessárias
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    // Endpoint para registro de usuários
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO body) {
        // Verifica se o email já está registrado
        Optional<User> user = this.repository.findByEmail(body.email());

        // Se o usuário não existe, cria um novo usuário
        if (user.isEmpty()) {
            User newUser = new User(body.name(), body.email(), body.idPapel(), passwordEncoder.encode(body.password()));
            this.repository.save(newUser);

            // Gera um token JWT para o novo usuário
            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getName(),newUser.getIdPapel(), token));
        }
        // Se o usuário já existe, retorna uma resposta de erro
        return ResponseEntity.badRequest().build();
    }

    // Endpoint para login de usuários
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body) {
        // Busca o usuário pelo email
        User user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));

        // Verifica se a senha fornecida corresponde à senha armazenada
        if (passwordEncoder.matches(body.password(), user.getPassword())) {
            // Gera um token JWT para o usuário autenticado
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getName(), user.getIdPapel() ,token));

        }
        // Se a senha não corresponder, retorna uma resposta de erro
        return ResponseEntity.badRequest().build();
    }
}
