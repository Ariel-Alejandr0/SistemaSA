package com.example.loginauthapi.service.melato;

import com.example.loginauthapi.domain.user.Erro;
import com.example.loginauthapi.repositories.RpErro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErroService {

    @Autowired
    private RpErro rperro;

    public List<ErroDTO> listar() {
        List<Erro> getAllerro   = rperro.findAll();
        return getAllerro.stream().map(ErroDTO::new).toList();
    }

    public void incluir(ErroDTO erro) {
        Erro Incluir = new Erro(erro);
        rperro.save(Incluir);
    }

    public ErroDTO alterar(ErroDTO erroDTO) {
        Erro Alterarproduto = new Erro(erroDTO);
        return new ErroDTO(rperro.save(Alterarproduto));
    }


    public void excluir(Long id) {
        Erro erro = rperro.findById(id).get();
        rperro.delete(erro);
    }
}
