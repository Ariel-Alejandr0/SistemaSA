package com.example.loginauthapi.service.rampeloti;


import com.example.loginauthapi.domain.user.EstoquePecas;
import com.example.loginauthapi.repositories.EstoquepecasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstoquepecasService {

    private EstoquepecasRepository repository;

    public void addPecas(EstoquePecasDTO estoquePecasDTO){
        EstoquePecas estoquepecas = new EstoquePecas();
        estoquepecas.setCusto(estoquePecasDTO.getCusto());
        estoquepecas.setDescricao(estoquePecasDTO.getDescricao());
        estoquepecas.setQuantidade(estoquePecasDTO.getQuantidade());
        repository.save(estoquepecas);
    }


    public void alterarPreco(EstoquePecasDTO estoquePecasDTO){
        EstoquePecas estoquepecas = repository.findById(estoquePecasDTO.getId()).orElseThrow(() -> new RuntimeException("Peca não encontrada"));
        estoquepecas.setCusto(estoquePecasDTO.getCusto());
        repository.save(estoquepecas);
    }

    public void alterarQuantidade(EstoquePecasDTO estoquePecasDTO){
        EstoquePecas estoquepecas = repository.findById(estoquePecasDTO.getId()).orElseThrow(() -> new RuntimeException("Peca não encontrada"));
        estoquepecas.setQuantidade(estoquePecasDTO.getQuantidade());
        repository.save(estoquepecas);
    }

    public List<EstoquePecas> listarTodos(){
        return repository.findAll();
    }
    public void excluirItem(Long id) {

        repository.deleteById(id);
    }
}
