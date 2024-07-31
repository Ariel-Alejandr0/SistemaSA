package com.example.loginauthapi.service.frank;


import com.example.loginauthapi.domain.user.Inventario;
import com.example.loginauthapi.repositories.InventarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InventarioService {

    private final InventarioRepository repository;

    public void adicionarItens(InventarioDTO inventarioDTO) {
        Inventario inventario = new Inventario();
        inventario.setItem(inventarioDTO.getItem());
        inventario.setCategoriaItem(inventarioDTO.getCategoriaItem());
        inventario.setValorItem(inventarioDTO.getValorItem());
        inventario.setLocalItem(inventarioDTO.getLocalItem());
        repository.save(inventario);
    }

    public void alterarItemdeLugar(Long id, LocalITem novoLocal) {
        Optional<Inventario> inventarioOptional = repository.findById(id);
        if (inventarioOptional.isPresent()) {
            Inventario inventario = inventarioOptional.get();
            inventario.setLocalItem(novoLocal);
            repository.save(inventario);
        } else {
            throw new RuntimeException("Item com ID " + id + " não encontrado.");
        }
    }

    public void excluirItem(Long id) {
        repository.deleteById(id);
    }

    public Inventario buscarItemPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Item com ID " + id + " não encontrado."));
    }

    public Iterable<Inventario> listarTodos() {
        return repository.findAll();
    }
}
