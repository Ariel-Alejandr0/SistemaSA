package com.example.loginauthapi.controllers;

import com.example.loginauthapi.domain.user.Machine;
import com.example.loginauthapi.domain.user.Usuario;
import com.example.loginauthapi.dto.RegisterRequestDTOmachine;
import com.example.loginauthapi.dto.ResponseDTOmachine;
import com.example.loginauthapi.dto.LoginRequestDTO;
import com.example.loginauthapi.dto.RegisterRequestDTO;
import com.example.loginauthapi.dto.ResponseDTO;
import com.example.loginauthapi.infra.security.TokenService;
import com.example.loginauthapi.repositories.MachineRepository;
import com.example.loginauthapi.repositories.UserRepository;

import com.example.loginauthapi.service.mm.websocket.MachineService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserRepository repository;
    private final MachineRepository machineRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final MachineService machineService;
//    private final EstoqueInsumosService estoqueInsumosService;

    @PostMapping("/register")
    public ResponseEntity<ResponseDTO> register(@RequestBody RegisterRequestDTO body) {
        Optional<Usuario> user = this.repository.findByEmail(body.email());

        if (user.isEmpty()) {
            Usuario newUser = new Usuario(body.nome(), body.email(), body.idPapel(), passwordEncoder.encode(body.senha()), body.pessoa(), body.dataCadastro());
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getNome(), newUser.getIdPapel(), token, newUser.getId_usuario(), newUser.getPessoa()));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/registerMachine")
    public ResponseEntity<ResponseDTOmachine> registerMachine(@RequestBody RegisterRequestDTOmachine body) {
        Optional<Machine> machine = machineRepository.findByName(body.name());

        if (machine.isEmpty()) {
            Optional<Usuario> usuario = repository.findById(body.idUsuario());
            if (usuario.isPresent()) {
                Machine newMachine = new Machine(body.name(), body.idTipoMaquina(), body.dataInstalacao(), body.setor(), usuario.get(), body.ultimaManutencao());
                machineRepository.save(newMachine);
                return ResponseEntity.ok(new ResponseDTOmachine(newMachine.getName(), newMachine.getSetor()));
            } else {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO body) {
        Usuario user = this.repository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(body.senha(), user.getSenha())) {
            String token = this.tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getNome(), user.getIdPapel(), token, user.getId_usuario(), user.getPessoa()));
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/allMachines")
    public ResponseEntity<List<Machine>> listMachines(){
        var machines = machineService.listAllMachines();

        return ResponseEntity.ok(machines);
    }
}