package com.example.loginauthapi.controllers;

import com.example.loginauthapi.domain.user.Machine;
import com.example.loginauthapi.domain.user.Usuario;
import com.example.loginauthapi.dto.machine.RegisterRequestDTOmachine;
import com.example.loginauthapi.dto.machine.ResponseDTOmachine;
import com.example.loginauthapi.dto.user.LoginRequestDTO;
import com.example.loginauthapi.dto.user.RegisterRequestDTO;
import com.example.loginauthapi.dto.user.ResponseDTO;
import com.example.loginauthapi.infra.security.TokenService;
import com.example.loginauthapi.repositories.MachineRepository;
import com.example.loginauthapi.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
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
    private final MachineRepository machineRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    // Endpoint para registro de usuários
    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO body) {
        // Verifica se o email já está registrado
        Optional<Usuario> user = this.repository.findByEmail(body.email());

        // Se o usuário não existe, cria um novo usuário
        if (user.isEmpty()) {
            Usuario newUser = new Usuario(body.nome(), body.email(), body.idPapel(), passwordEncoder.encode(body.senha()), body.idPessoa(), body.dataCadastro());
            this.repository.save(newUser);

            // Gera um token JWT para o novo usuário
            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getNome(),newUser.getIdPapel(), token, newUser.getId_usuario(), newUser.getIdPessoa()));
        }
        // Se o usuário já existe, retorna uma resposta de erro
        return ResponseEntity.badRequest().build();
    }


    //REGISTRO DE MÁQUINA
    @PostMapping("/registerMachine")
    public ResponseEntity<ResponseDTOmachine> registerMachine(@RequestBody RegisterRequestDTOmachine body) {
        // Verifica se a máquina já está registrada
        Optional<Machine> machine = machineRepository.findByName(body.name());

        // Se a máquina não existe, cria uma nova máquina
        if (machine.isEmpty()) {
            Machine newMachine = new Machine(body.name(), body.idTipoMaquina(), body.dataInstalacao(),body.setor(), body.idUsuario(), body.ultimaManutencao());
            machineRepository.save(newMachine);
            return ResponseEntity.ok(new ResponseDTOmachine(newMachine.getName(), newMachine.getSetor()));
        }
        // Se a máquina já existe, retorna uma resposta de erro
        return ResponseEntity.badRequest().build();
    }






    // Endpoint para login de usuários
    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body) {
        // Busca o usuário pelo email
        Usuario user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));

        // Verifica se a senha fornecida corresponde à senha armazenada
        if (passwordEncoder.matches(body.senha(), user.getSenha())) {
            // Gera um token JWT para o usuário autenticado
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getNome(), user.getIdPapel() ,token, user.getId_usuario(), user.getIdPessoa()));

        }
        // Se a senha não corresponder, retorna uma resposta de erro
        return ResponseEntity.badRequest().build();
    }
}
