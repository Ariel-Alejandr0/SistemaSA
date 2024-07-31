package com.example.loginauthapi.service.xadrez;

import com.example.loginauthapi.domain.user.Localizacao;
import com.example.loginauthapi.repositories.LocalizacaoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class LocalizacaoService {

    private final LocalizacaoRepository repository;

    @Autowired
    public LocalizacaoService(LocalizacaoRepository repository) {
        this.repository = repository;
    }

    public void criarLocalizacao(LocalizacaoDTO localizacaoDTO) {
        Localizacao localizacao = new Localizacao();
        localizacao.setId_localizacao(localizacaoDTO.getId_localizacao());
        localizacao.setEnderacamento(localizacaoDTO.getEnderacamento());

        repository.save(localizacao);
    }

    public void updateLocalizacao(LocalizacaoDTO localizacaoDTO) {
        Localizacao localizacao = repository.findById(localizacaoDTO.getId_localizacao()).orElseThrow(() -> new RuntimeException("Localizacao não encontrada"));
        localizacao.setId_localizacao(localizacaoDTO.getId_localizacao());
        localizacao.setEnderacamento(localizacaoDTO.getEnderacamento());
        repository.save(localizacao);
    }

    public Localizacao findById(Long id) {
        Optional<Localizacao> result = repository.findById(id);

        Localizacao localizacao;

        if (result.isPresent()) {
            localizacao = result.get();
        } else {
            throw new RuntimeException("Localizacao não encontrada");
        }

        return localizacao;
    }

    public List<Localizacao> findAll() {
        return repository.findAll();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
